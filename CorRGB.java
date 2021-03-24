class CorRGB
{
    private int valorRed;
    private int valorGreen;
    private int valorBlue;
    private double valorLuminosidade;
    
    
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
                this.setLuminosidade();
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
        this.setLuminosidade();
    }

    //Copia
    CorRGB(CorRGB x){

        this.setValorRed(x.getValorRed());
        this.setValorGreen(x.getValorGreen());
        this.setValorBlue(x.getValorBlue());
        this.setLuminosidade(); 

    }



    public int getValorRed() {
        return valorRed;
    }

    private void setValorRed(int valorRed) 
    {
        if(valorRed >= 255)
        {this.valorRed = 255;}
        else
        {
            if(valorRed < 0)
            {this.valorRed = 0;}
            else
            {this.valorRed = valorRed;}
        }
        this.setLuminosidade();
    }
    
    public int getValorGreen() {
        return valorGreen;
    }

    private void setValorGreen(int valorGreen) {
        if(valorGreen >= 255)
        {this.valorGreen = 255;}
        else
        {
            if(valorGreen < 0)
            {this.valorGreen = 0;}
            else
            {this.valorGreen = valorGreen;}
        }
        this.setLuminosidade();
    }


    public int getValorBlue() {
        return valorBlue;
    }

    private void setValorBlue(int valorBlue) {
        if(valorBlue >= 255)
        {this.valorBlue = 255;}
        else
        {
            if(valorBlue < 0)
            {this.valorBlue = 0;}
            else
            {this.valorBlue = valorBlue;}
        }
        this.setLuminosidade();
    }

    public double getLuminosidade()
    {
        return valorLuminosidade;
    }
    
    private void setLuminosidade()
    {
        this.valorLuminosidade = (this.getValorRed()*0.3 + this.getValorGreen()*0.59 + this.getValorBlue()*0.11) / 255;
    }
    
    public CorRGB clonar()
    {
        CorRGB clone = new CorRGB(this.getValorRed(),this.getValorGreen(),this.getValorBlue());
        return clone;
    }
    
    public boolean setIgualdadeCores(CorRGB x) 
    {
        if (this.getValorRed() == x.getValorRed() &&
            this.getValorGreen() == x.getValorGreen() &&
            this.getValorBlue() == x.getValorBlue()) 
        {return true;}
        else
        {return false;}
    }
    
    private String conversorHexadecimal(int number) {

        String [] vetorDeHexa = new String [3];
        int x =0;
        do {
            if (number % 16 < 10) {
                vetorDeHexa[x]= String.valueOf((number % 16));

            } else {
                switch (number % 16) {
                    case 10: vetorDeHexa[x]= "A";break;
                    case 11: vetorDeHexa[x]= "B";break;
                    case 12: vetorDeHexa[x]= "C";break;
                    case 13: vetorDeHexa[x]= "D";break;
                    case 14: vetorDeHexa[x]= "E";break;
                    case 15: vetorDeHexa[x]= "F";break;
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
    
    public void clarear(float percentual)
    {
        setValorRed(getValorRed() + (int)(getValorRed()*percentual));
        setValorGreen(getValorGreen() + (int)(getValorGreen()*percentual));
        setValorBlue(getValorBlue() + (int)(getValorBlue()*percentual));
    }
    
    public void escurecer(float percentual)
    {
        setValorRed(getValorRed() - (int)(getValorRed()*percentual));
        setValorGreen(getValorGreen() - (int)(getValorGreen()*percentual));
        setValorBlue(getValorBlue() - (int)(getValorBlue()*percentual));
    }
    
    @Override
    public String toString(){
        String s = "";


        s +=    "valor de vermelho: "+ this.valorRed +"\n"+
                "valor de verde: "+ this.valorGreen +"\n"+
                "valor de azul: " + this.valorBlue +"\n"+
                "Luminosidade: " + this.valorLuminosidade +"\n";
        return s;
    }
}

