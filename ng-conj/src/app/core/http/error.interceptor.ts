import { HttpEvent, HttpEventType, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

export class ErrorInterceptor implements HttpInterceptor {

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler,
  ): Observable<HttpEvent<any>> {
    console.log('Interceptor input:\n', req);

    return next.handle(req).pipe(
      tap((event) => {
        if (event.type === HttpEventType.Response)
          console.log('Interceptor\'s caught the error:\n', event);
      }),
    );
  }
}
