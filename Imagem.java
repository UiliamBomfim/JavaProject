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

    private String conversorHexadecimal(int valor)
    {
        int dezenaHexa;
        int unidadeHexa;
        String dezenaHexaStr = "";
        String unidadeHexaStr = "";

        dezenaHexa = (int) valor/16;
        unidadeHexa = (int) ((valor/16.0 - dezenaHexa) * 16.0);

        switch(unidadeHexa)
        {
            case 10: unidadeHexaStr = "A";break;
            case 11: unidadeHexaStr = "B";break;
            case 12: unidadeHexaStr = "C";break;
            case 13: unidadeHexaStr = "D";break;
            case 14: unidadeHexaStr = "E";break;
            case 15: unidadeHexaStr = "F";break;
            default: unidadeHexaStr = "" + unidadeHexa;
        }
        switch(dezenaHexa)
        {
            case 10: dezenaHexaStr = "A";break;
            case 11: dezenaHexaStr = "B";break;
            case 12: dezenaHexaStr = "C";break;
            case 13: dezenaHexaStr = "D";break;
            case 14: dezenaHexaStr = "E";break;
            case 15: dezenaHexaStr = "F";break;
            default: dezenaHexaStr = "" + dezenaHexa;
        }

        return dezenaHexaStr + unidadeHexaStr;
    }

    private int conversorDecimal(char unidadeHexaStr, char dezenaHexaStr)
    {
        int dezenaHexa;
        int unidadeHexa;


        switch(unidadeHexaStr)
        {
            case 'A': unidadeHexa = 10;break;
            case 'B': unidadeHexa = 11;break;
            case 'C': unidadeHexa = 12;break;
            case 'D': unidadeHexa = 13;break;
            case 'E': unidadeHexa = 14;break;
            case 'F': unidadeHexa = 15;break;
            default:  unidadeHexa = Integer.parseInt(String.valueOf(unidadeHexaStr));
        }
        
        switch(dezenaHexaStr)
        {
            case 'A': dezenaHexa = 10;break;
            case 'B': dezenaHexa = 11;break;
            case 'C': dezenaHexa = 12;break;
            case 'D': dezenaHexa = 13;break;
            case 'E': dezenaHexa = 14;break;
            case 'F': dezenaHexa = 15;break;
            default:  dezenaHexa = Integer.parseInt(String.valueOf(dezenaHexaStr));
        }

        return (dezenaHexa*16)+unidadeHexa;

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