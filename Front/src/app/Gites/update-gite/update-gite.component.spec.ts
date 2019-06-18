import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateGiteComponent } from './update-gite.component';

describe('UpdateGiteComponent', () => {
  let component: UpdateGiteComponent;
  let fixture: ComponentFixture<UpdateGiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateGiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateGiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
