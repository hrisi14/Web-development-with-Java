import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeparateCatalogueComponent } from './separate-catalogue.component';

describe('SeparateCatalogueComponent', () => {
  let component: SeparateCatalogueComponent;
  let fixture: ComponentFixture<SeparateCatalogueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SeparateCatalogueComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SeparateCatalogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
