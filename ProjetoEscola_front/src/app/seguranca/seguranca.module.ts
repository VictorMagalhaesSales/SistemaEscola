import { AuthService } from './auth.service';
import { AuthGuard } from './auth.guard';
import { AuthInterceptor } from './auth.interceptor ';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/components/common/messageservice';
import { JwtHelperService, JwtModule } from '@auth0/angular-jwt';
import { NavbarModule, WavesModule, ButtonsModule, InputsModule, CardsFreeModule, MDBBootstrapModule } from 'angular-bootstrap-md';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    JwtModule,

    NavbarModule,
    WavesModule,
    ButtonsModule,
    InputsModule,
    CardsFreeModule,
    MDBBootstrapModule.forRoot(),
    ToastModule
  ],
  providers: [
    JwtHelperService,
    MessageService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
     },
     AuthGuard,
     AuthService
    ],
  declarations: [LoginComponent]
})
export class SegurancaModule { }
