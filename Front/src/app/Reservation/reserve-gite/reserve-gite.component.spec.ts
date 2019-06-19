import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReserveGiteComponent } from './reserve-gite.component';

describe('ReserveGiteComponent', () => {
  let component: ReserveGiteComponent;
  let fixture: ComponentFixture<ReserveGiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReserveGiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReserveGiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
