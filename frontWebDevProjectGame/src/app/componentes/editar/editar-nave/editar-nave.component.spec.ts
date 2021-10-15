import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarNaveComponent } from './editar-nave.component';

describe('EditarNaveComponent', () => {
  let component: EditarNaveComponent;
  let fixture: ComponentFixture<EditarNaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarNaveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarNaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
