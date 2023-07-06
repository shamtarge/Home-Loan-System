import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientLoginComponent } from './Components/client-login/client-login.component';
import { AdminLoginComponent } from './Components/admin-login/admin-login.component';
import { UserRegisterationComponent } from './Components/user-registeration/user-registeration.component';
import { HeaderComponent } from './Components/Home/header/header.component';
import { ContentComponent } from './Components/Home/content/content.component';
import { DashboardHeaderComponent } from './Components/UserDashboard/dashboard-header/dashboard-header.component';
import { DashboardContentComponent } from './Components/UserDashboard/dashboard-content/dashboard-content.component';
import { ApplyLoanComponent } from './Components/apply-loan/apply-loan.component';
import { ViewStatusComponent } from './Components/view-status/view-status.component';
import { ViewStatusOfAllComponent } from './Components/view-status-of-all/view-status-of-all.component';
import { PremiumComponent } from './Components/premium/premium.component';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ClientProfileComponent } from './Components/client-profile/client-profile.component';
import { AdminProfileComponent } from './Components/admin-profile/admin-profile.component';
import { AdminContentComponent } from './Components/AdminDashboard/admin-content/admin-content.component';
import { AdminHeaderComponent } from './Components/AdminDashboard/admin-header/admin-header.component';
import { ApplyLoanAdminComponent } from './Components/apply-loan-admin/apply-loan-admin.component';
import { ChangeAdminPasswordComponent } from './Components/change-admin-password/change-admin-password.component';
import { ChangeClientPasswordComponent } from './Components/change-client-password/change-client-password.component';
import { PremiumAdminComponent } from './Components/premium-admin/premium-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientLoginComponent,
    AdminLoginComponent,
    UserRegisterationComponent,
    HeaderComponent,
    ContentComponent,
    DashboardHeaderComponent,
    DashboardContentComponent,
    ApplyLoanComponent,
    ViewStatusComponent,
    ViewStatusOfAllComponent,
    PremiumComponent,
    ClientProfileComponent,
    AdminProfileComponent,
    AdminContentComponent,
    AdminHeaderComponent,
    ApplyLoanAdminComponent,
    ChangeAdminPasswordComponent,
    ChangeClientPasswordComponent,
    PremiumAdminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
