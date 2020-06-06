import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentloginsucesssComponent } from './studentloginsucesss.component';

describe('StudentloginsucesssComponent', () => {
  let component: StudentloginsucesssComponent;
  let fixture: ComponentFixture<StudentloginsucesssComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentloginsucesssComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentloginsucesssComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
