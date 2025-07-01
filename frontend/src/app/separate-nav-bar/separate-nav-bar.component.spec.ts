import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeparateNavBarComponent } from './separate-nav-bar.component';

describe('SeparateNavBarComponent', () => {
  let component: SeparateNavBarComponent;
  let fixture: ComponentFixture<SeparateNavBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SeparateNavBarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SeparateNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
