public class MainActivity extends AppCompatActivity {
    EditText nombre;// declaramos todos los id necesarios
    EditText apellidos;
    EditText edad;
    EditText otro;
    CheckBox participado;
    ImageButton boton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //buscamos los recursos para poder usarlos
        otro = findViewById(R.id.otro);
        participado = findViewById(R.id.participado);
        boton = findViewById(R.id.boton);
        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
        edad = findViewById(R.id.edad);
        
    }
    
    public void clickotro (View view) {
        //obtengo si hace click en el check de participación en otro
        CheckBox clickotro = (CheckBox)view;
         if (clickotro.isChecked()){
             otro.setVisibility(View.VISIBLE);//si marcha check le muestro el EditText para que escriba el nombre del otro concurso
        }
        else {
             otro.setVisibility(View.INVISIBLE);//si no lo ha marcado se lo mantengo invisible
        }
    }

    public void enviarformulario (View form){
        boolean hayErrores = false;//me creo un booleano para almacenar errores
        String mensajeError = "";//los string para mostar en texto los errores

        String elNombre = nombre.getText().toString();//obtengo el texto que ha escrito el usuario
        if (elNombre.equals("")){//si no ha escrito nada
            hayErrores = true;//marco el error
            mensajeError = "No ha escrito su nombre";//guardo el mensaje de error para mostrar al final
        }

        String elApellido = apellidos.getText().toString();//igual que el nombre
        if (elApellido.equals("")){
            hayErrores = true;
            mensajeError += " - No ha escrito su apellidos";
        }

        String laEdad = edad.getText().toString();//igual que el nombre
        if (laEdad.equals("")){
            hayErrores = true;
            mensajeError += " - No ha escrito la Edad";
        }
        else {
            int edad = Integer.parseInt(laEdad);//aquí verifico si el usuario es menor de 18
            if (edad<18) {
                hayErrores = true;
                mensajeError += " - No puede registrarse es un menor de edad";
            }
        }

        if (participado.isChecked()) {//compruebo si marca que ha participado en otro concurso
            String elOtro = otro.getText().toString();//recibo el nombre del otro concurso
            if (elOtro.equals("")){//si a pesar de haber marcado su participación no lo ha escrito
                hayErrores = true;//marco el error
                mensajeError += " - No ha escrito el nombre del otro concurso";//guardo mensaje
            }
        }

        if (!hayErrores) {//Si el formulario está correcto muesto Toast de finalización correcta
            Toast.makeText(this, "Formulario Enviado Correctamente", Toast.LENGTH_LONG).show();
        }
        else {//si hay errores muestro los mensajes de error con el Toast
            Toast.makeText(this, mensajeError, Toast.LENGTH_LONG).show();
        }
    }
    
}