import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FollowedEventsComponent } from './followed-events.component';

describe('FollowedEventsComponent', () => {
  let component: FollowedEventsComponent;
  let fixture: ComponentFixture<FollowedEventsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FollowedEventsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FollowedEventsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
