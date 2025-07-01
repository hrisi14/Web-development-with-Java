import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisitedEventsComponent } from './visited-events.component';

describe('VisitedEventsComponent', () => {
  let component: VisitedEventsComponent;
  let fixture: ComponentFixture<VisitedEventsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VisitedEventsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VisitedEventsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
