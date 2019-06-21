import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewSaisonComponent } from './new-saison.component';

describe('NewSaisonComponent', () => {
  let component: NewSaisonComponent;
  let fixture: ComponentFixture<NewSaisonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewSaisonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewSaisonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
