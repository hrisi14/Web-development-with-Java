import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganizedEventsComponent } from './organized-events.component';

describe('OrganizedEventsComponent', () => {
  let component: OrganizedEventsComponent;
  let fixture: ComponentFixture<OrganizedEventsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrganizedEventsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrganizedEventsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
