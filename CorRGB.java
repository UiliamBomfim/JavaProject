class CorRGB
{
    public final int valorRed = 0 ;
    public final int valorGreen = 1;
    public final int valorBlue = 2;
    public final int lum = 0;
    
    int [] vetorDeCores = new int [3];
    double []vetorLuminosidade = new double[1];


    //construtor cor RGB
    CorRGB(int red, int green, int blue)
    {
        try
        {
            if (red <= 0 || red >= 255 || green <= 0 || green >= 255 || blue <= 0 || blue >= 255  )

                throw new Exception("Número inválido");
            else {
                this.setValorRed(red);
                this.setValorGreen(green);
                this.setValorBlue(blue);
                vetorLuminosidade[lum] = ((red*0.3) + (green*0.59) + (blue *0.11) / 255);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //CorPreta
    CorRGB()
    {
        this.setValorRed(0);
        this.setValorGreen(0);
        this.setValorBlue(0);
        this.vetorLuminosidade[0]= 0;
    }

    //Copia
    CorRGB(CorRGB x){

        this.setValorRed(x.getValorRed());
        this.setValorGreen(x.getValorGreen());
        this.setValorBlue(x.getValorBlue());
        this.vetorLuminosidade[0]= x.getLuminosidade();

    }



    public int getValorRed() {
        return vetorDeCores[valorRed];
    }

    public void setValorRed(int red) {
        vetorDeCores[valorRed] = red;
    }

    public int getValorGreen() {
        return vetorDeCores[valorGreen];
    }

    public void setValorGreen(int green) {
        vetorDeCores[valorGreen] = green;
    }

    public int getValorBlue() {
        return vetorDeCores[valorBlue];
    }

    public void setValorBlue(int blue) {
         vetorDeCores[valorBlue] = blue;
    }

    public double getLuminosidade(){
       
        return vetorLuminosidade[0];
    }

    public boolean setIgualdadeCores(CorRGB x) {


        if (this.getValorRed() == x.getValorRed() &&
                this.getValorGreen() == x.getValorGreen() &&
                this.getValorBlue() == x.getValorBlue()) {

            return true;
        } else
            return false;
    }
    
    private String conversorHexadecimal(int number) {

        String [] vetorDeHexa = new String [3];
        int x =0;

        do {
            if (number % 16 < 10) {
                vetorDeHexa[x]= String.valueOf((number % 16));

            } else {
                switch (number % 16) {
                    case 10:
                        vetorDeHexa[x]= "A";
                        break;
                    case 11:
                        vetorDeHexa[x]= "B";
                        break;
                    case 12:
                        vetorDeHexa[x]= "C";
                        break;
                    case 13:
                        vetorDeHexa[x]= "D";
                        break;
                    case 14:
                      vetorDeHexa[x]= "E";
                        break;
                    case 15:
                      vetorDeHexa[x]= "F";
                }
            }
            number = (int) number / 16;
            x++;
        } while (number != 0);
            String s= "";
            s += vetorDeHexa[1]+vetorDeHexa[0];
        return s;
    }

    public String CorRGBHexadecimal(){
        String r= "RGB em Hexa: #";
        r += this.conversorHexadecimal(getValorRed()) +
        this.conversorHexadecimal(getValorGreen())+
        this.conversorHexadecimal(getValorBlue());

        return r;
    }

    @Override
    public String toString(){
        String s = "";


        s +=    "valor de vermelho: "+ vetorDeCores[0]+"\n"+
                "valor de verde: "+ vetorDeCores[1] +"\n"+
                "valor de azul: " + vetorDeCores[2] +"\n"+
                "Luminosidade: " + vetorLuminosidade[0] +"\n";
        return s;
    }




}

