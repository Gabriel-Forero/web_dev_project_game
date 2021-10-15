import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarEstrellaComponent } from './editar-estrella.component';

describe('EditarEstrellaComponent', () => {
  let component: EditarEstrellaComponent;
  let fixture: ComponentFixture<EditarEstrellaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarEstrellaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarEstrellaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
