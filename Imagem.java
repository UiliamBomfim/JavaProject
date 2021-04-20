import java.util.Arrays;

public class Imagem {

    private CorRGB [][] pixels;


        Imagem(int x, int y)
        {
            pixels = new CorRGB[x][y];

                for(int k=0; k<x; k++)
                {
                    for(int w=0; w<y; w++)
                    {
                        pixels[k][w]= CorRGB.branca;
                    }
                }
        }


    public CorRGB getPixel(int x, int y)
    {
        return this.pixels[x][y];
    }

    public String getPixels()
    {
        String s = "";

        for(int k=0; k<pixels.length; k++)
        {
            for(int w=0; w<pixels[k].length; w++)
            {

                s += pixels[k][w];

            }
        }
            return s;
    }

    public void setModificaPixels(int x, int y, int a, int b, int c)
    {
    
                        this.pixels[x][y].setValorRed(a);
                        this.pixels[x][y].setValorGreen(b);
                        this.pixels[x][y].setValorBlue(c);
    
    }
    
    public Imagem imagemCinza() {

        int cinza = 0;

        Imagem imagem = new Imagem(this.pixels.length,this.pixels[0].length);


        for (int x = 0; x < this.pixels.length; x++)
        {
            for (int y = 0; y < this.pixels[x].length; y++)
            {
                cinza = (int) this.pixels[x][y].getLuminosidade();
               imagem.setModificaPixels(x,y,cinza,cinza,cinza);
            }

        }
                return imagem;
    }
    
     public void verificarIgualdadeImagem(Imagem x)
    {
          if(Arrays.deepEquals(this.pixels, x.pixels))
          {
              System.out.println("sao iguais");
          }
          else
          {
              System.out.println("sao diferentes");
          }
    }
    
}