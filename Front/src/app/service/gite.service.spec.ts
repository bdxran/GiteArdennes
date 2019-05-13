import { TestBed } from '@angular/core/testing';

import { GiteService } from './gite.service';

describe('GiteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GiteService = TestBed.get(GiteService);
    expect(service).toBeTruthy();
  });
});
