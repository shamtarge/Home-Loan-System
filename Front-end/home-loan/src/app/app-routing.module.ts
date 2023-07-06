import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContentComponent } from './Components/Home/content/content.component';
import { AdminLoginComponent } from './Components/admin-login/admin-login.component';
import { ClientLoginComponent } from './Components/client-login/client-login.component';
import { UserRegisterationComponent } from './Components/user-registeration/user-registeration.component';
import { DashboardContentComponent } from './Components/UserDashboard/dashboard-content/dashboard-content.component';
import { PremiumComponent } from './Components/premium/premium.component';
import { ViewStatusComponent } from './Components/view-status/view-status.component';
import { ApplyLoanComponent } from './Components/apply-loan/apply-loan.component';
import { ViewStatusOfAllComponent } from './Components/view-status-of-all/view-status-of-all.component';
import { ClientProfileComponent } from './Components/client-profile/client-profile.component';
import { AdminContentComponent } from './Components/AdminDashboard/admin-content/admin-content.component';
import { AdminProfileComponent } from './Components/admin-profile/admin-profile.component';
import { ApplyLoanAdminComponent } from './Components/apply-loan-admin/apply-loan-admin.component';
import { ChangeClientPasswordComponent } from './Components/change-client-password/change-client-password.component';
import { ChangeAdminPasswordComponent } from './Components/change-admin-password/change-admin-password.component';
import { PremiumAdminComponent } from './Components/premium-admin/premium-admin.component';
const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([
    {path:'', redirectTo:'home', pathMatch:'full'},
    {path:'home', component: ContentComponent},
    {path:'adminLogin',component: AdminLoginComponent},
    {path:'clientLogin',component: ClientLoginComponent},
    {path:'register',component: UserRegisterationComponent},
    {path:'client',component: DashboardContentComponent},
    {path:'admin',component: AdminContentComponent},
    {path:'user/status',component: ViewStatusComponent},
    {path:'status',component: ViewStatusOfAllComponent},
    {path:'applyLoan',component: ApplyLoanComponent},
    {path:'applyLoanAdmin',component: ApplyLoanAdminComponent},
    {path:'clientProfile',component: ClientProfileComponent},
    {path:'adminProfile',component: AdminProfileComponent},
    {path:'payPremium',component: PremiumComponent},
    {path:'payPremiumAdmin',component: PremiumAdminComponent},
    {path:'changeAdminPassword',component: ChangeAdminPasswordComponent},
    {path:'changeClientPassword',component: ChangeClientPasswordComponent}
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
