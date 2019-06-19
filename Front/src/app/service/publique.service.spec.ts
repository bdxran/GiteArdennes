import { TestBed } from '@angular/core/testing';

import { PubliqueService } from './publique.service';

describe('PubliqueService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PubliqueService = TestBed.get(PubliqueService);
    expect(service).toBeTruthy();
  });
});
