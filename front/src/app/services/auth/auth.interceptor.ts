import {HttpInterceptorFn} from '@angular/common/http';
import {inject} from "@angular/core";
import {AuthService} from "./auth.service";

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(AuthService);
  const authToken = authService.getToken();
  const noTokenUrl = authToken == null ;
  if (noTokenUrl) {
    const authReq = req.clone({
      setHeaders: {
        ContentType: 'application/json'
      }
    });
    return next(authReq);
  }
  const authReq = req.clone({
    setHeaders: {
      Authorization: `Bearer ${authToken}`,
      ContentType: 'application/json'
    }
  });
  return next(authReq);
};
