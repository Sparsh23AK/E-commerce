import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { AdminComponent } from './admin/admin.component';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { ProductPageComponent } from './product-page/product-page.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './_auth/auth.guard';

const routes: Routes = [
  { path: 'admin', component: AdminComponent, canActivate:[AuthGuard], data:{roles:['Admin']} },
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'view-product', component: ProductPageComponent },
  { path: 'cart', component: CartComponent },
  { path: 'orderDetails', component: OrderDetailsComponent },
  { path: 'aboutUs', component: AboutUsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
