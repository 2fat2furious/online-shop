import { Component } from '@angular/core';
import { TypesService } from './types.service';

@Component({
  selector: 'app-root',
  template: `<div>
          <nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo"><img width="55" alt="Angular Logo" src="assets/image/1.png"><font color="black">Fake-shop</font></a>
      
      <ul id="nav-mobile" class="right hide-on-med-and-down">
      <li><a routerLink="/add" class="waves-effect waves-light btn">INSERT</a></li>
        <li><a routerLink="/types"><font color="black">Types</font></a></li>
        <li><a routerLink="/brands"><font color="black">Brands</font></a></li>
        <li><a routerLink="/products"><font color="black">Products</font></a></li>
      </ul>
    </div>
  </nav>
            <router-outlet></router-outlet>
            </div>`,
  styleUrls: ['./app.component.css'],
  providers: [TypesService]
})
export class AppComponent {
  title = 'online-shop';
}