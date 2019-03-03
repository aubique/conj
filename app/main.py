#!python

import requests
import re
from flask import Flask, request
from flask_sslify import SSLify
import json
# authbot.py security-file
import authbot

PATTERN = r'\d+\s*[\+\-\*\/]{1}\s*\d+'
BASE_URL = 'https://api.telegram.org/bot'
WEBHOOK = 'https://ubikwita.pythonanywhere.com'

app = Flask(__name__)
sslify = SSLify(app)

def set_webhook():
    #TODO: make it working well on the initial launch
    add_url = 'setWebhook?url={}'.format(WEBHOOK)
    url = get_url(add_url)
    return requests.get(url)

def save_json(text, filename='telegram-data.json'):
    # Save text in JSON format
    with open(filename, 'w') as f:
        json.dump(text, f, indent=2, ensure_ascii=False)

def get_url(argum):
    # Get telegram BOT-TOKEN from the authbot.py file
    url = BASE_URL + authbot.TOKEN + '/' + argum
    return url

def send_message(message_dict):
    url = get_url('sendMessage')
    r = requests.post(url, json=message_dict)
    return r.json()

def compile_message_dict(cid, txt):
    # Return a message with id-text in dictionary-format
    message_dict = {'chat_id': cid, 'text': txt}
    return message_dict

def get_message_dict():
    # Get the latest messag from Flask server
    r = request.get_json()
    # message->chat->id
    cid = r['message']['chat']['id']
    txt = r['message']['text']
    return compile_message_dict(cid, txt)

def get_chat_id(message_dict):
    return message_dict['chat_id']

def get_message_text(message_dict):
    return message_dict['text']

def parse_calculate(text):
    # Grab a regexp-pattern and calculate it
    crypto = re.search(PATTERN, text)
    if crypto:
        return eval(crypto.group())
    return None

@app.route('/', methods=['POST', 'GET'])
def index():
    if request.method == 'POST':
        msg = get_message_dict()
        msg_text = get_message_text(msg)
        msg_cid = get_chat_id(msg)

        result = parse_calculate(msg_text)
        if result:
            response_msg = compile_message_dict(msg_cid, result)
            send_message(response_msg)
    return '<h1>Greetings</h1>'

def main():
    pass

if __name__ == '__main__':
    app.run()
