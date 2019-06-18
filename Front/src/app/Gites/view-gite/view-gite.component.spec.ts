import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewGiteComponent } from './view-gite.component';

describe('ViewGiteComponent', () => {
  let component: ViewGiteComponent;
  let fixture: ComponentFixture<ViewGiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewGiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewGiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
