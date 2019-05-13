import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewGiteComponent } from './new-gite.component';

describe('NewGiteComponent', () => {
  let component: NewGiteComponent;
  let fixture: ComponentFixture<NewGiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewGiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewGiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
