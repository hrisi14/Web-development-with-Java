import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventContainerComponent } from './event-container.component';

describe('EventContainerComponent', () => {
  let component: EventContainerComponent;
  let fixture: ComponentFixture<EventContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EventContainerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EventContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
