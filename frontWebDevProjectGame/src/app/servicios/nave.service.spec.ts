import { TestBed } from '@angular/core/testing';

import { NaveService } from './nave.service';

describe('NaveService', () => {
  let service: NaveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NaveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
