import { PruebaAppPage } from './app.po';

describe('prueba-app App', function() {
  let page: PruebaAppPage;

  beforeEach(() => {
    page = new PruebaAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
