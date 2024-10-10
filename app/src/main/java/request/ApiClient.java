package request;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;



import model.Usuario;

public class ApiClient {
    private static SharedPreferences sp;

    public static SharedPreferences conectar(Context context) {
        if(sp == null)
        {
            sp = context.getSharedPreferences("Datos", 0);
        }
        return sp;
    }

    public static Usuario login(Context context, String mail, String pass){
        Usuario usuario = null;
        SharedPreferences sp = conectar(context);

        Long dni = sp.getLong("dni",-1);
        String apellido = sp.getString("apellido","-1");
        String nombre = sp.getString("nombre","-1");
        String email = sp.getString("mail","-1");
        String password = sp.getString("password","-1");

        if(email.equals(mail) && password.equals(pass)){
            usuario = new Usuario(dni, nombre, apellido, mail, pass);
        }
        return usuario;
    }

    public static Usuario leer(Context context){
        SharedPreferences sp = conectar(context);

        Long dni = sp.getLong("dni",-1);
        String apellido = sp.getString("apellido","-1");
        String nombre = sp.getString("nombre","-1");
        String mail = sp.getString("mail","-1");
        String pass = sp.getString("password","-1");

        Usuario usuario = new Usuario(dni, nombre, apellido, mail, pass);
        return usuario;
    }

    public static void Guardar(Context context, Usuario usuario)
    {
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor =  sp.edit();
        editor.putLong("dni",usuario.getDni());
        editor.putString("apellido", usuario.getApellido());
        editor.putString("nombre", usuario.getNombre());
        editor.putString("mail", usuario.getMail());
        editor.putString("password", usuario.getPass());


        editor.commit();
        Toast.makeText(context.getApplicationContext(), "Datos Guardados Correctamente", Toast.LENGTH_LONG).show();


    }
}
