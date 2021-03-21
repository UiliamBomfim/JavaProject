class CorRGB
{
    private int valorRed;
    private int valorGreen;
    private int valorBlue;
    
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
                this.setValorBlue(blue);}
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
    }
    
    //Copia
    CorRGB(CorRGB x){
         
       this.setValorRed(x.getValorRed());
       this.setValorGreen(x.getValorGreen());
       this.setValorBlue(x.getValorBlue());
         
    }



    public int getValorRed() {
        return valorRed;
    }

    public void setValorRed(int valorRed) {
        this.valorRed = valorRed;
    }

    public int getValorGreen() {
        return valorGreen;
    }

    public void setValorGreen(int valorGreen) {
        this.valorGreen = valorGreen;
    }

    public int getValorBlue() {
        return valorBlue;
    }

    public void setValorBlue(int valorBlue) {
        this.valorBlue = valorBlue;
    }

    //public double getLuminosidade(){  }

   

    @Override
    public String toString(){
        String s = "";


            s +=    "valor de vermelho: "+ valorRed +"\n"+
                    "valor de verde: "+ valorGreen +"\n"+
                    "valor de azul: " + valorBlue+"\n";
        return s;
        }


 

}

