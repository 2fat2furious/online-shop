import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TypeComponent } from './type/type.component';
import { ProductComponent } from './product/product.component';
import { BrandComponent } from './brand/brand.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductsService } from './products.service';
import { TypesService } from './types.service';
import { BrandsService } from './brands.service';
import { ItemComponent } from './item/item.component';
import { FormsModule } from '@angular/forms';
import { FormComponent } from './form/form.component';
import { UpdateComponent } from './update/update.component';

const appRoutes: Routes = [
  { path: 'products', component: ProductComponent },
  { path: 'types', component: TypeComponent },
  { path: 'brands', component: BrandComponent },
  { path: 'products/:id', component: ItemComponent },
  { path: 'add', component: FormComponent },
  { path: 'update/:id', component: UpdateComponent }
  // {path:'', component: AppComponent}

];



@NgModule({
  declarations: [
    AppComponent,
    TypeComponent,
    ProductComponent,
    BrandComponent,
    ItemComponent,
    FormComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule

  ],
  providers: [BrandsService, ProductsService, TypesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
