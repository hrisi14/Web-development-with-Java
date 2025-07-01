import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';


@Component({
  selector: 'app-separate-nav-bar',
  imports: [CommonModule, RouterModule],
  standalone: true,
  templateUrl: './separate-nav-bar.component.html',
  styleUrl: './separate-nav-bar.component.css'
})
export class SeparateNavBarComponent {
      constructor(private router: Router) {}
}

