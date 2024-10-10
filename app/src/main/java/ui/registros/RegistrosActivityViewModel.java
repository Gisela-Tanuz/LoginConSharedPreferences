package ui.registros;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import model.Usuario;
import request.ApiClient;

public class RegistrosActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Usuario> mUsuario;

    public RegistrosActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }


    public LiveData<Usuario> getUsuario()
    {
        if(mUsuario == null)
        {
            mUsuario = new MutableLiveData<>();
        }
        return mUsuario;
    }
    public void guardar(String nombre, String apellido, long dni, String mail, String pass){
        Usuario u = new Usuario(dni, nombre, apellido, mail, pass);
        ApiClient.Guardar(context, u);
    }
    public void recuperarUsuario()
    {
        Usuario us = ApiClient.leer(context);
        if(us != null)
        {
            mUsuario.setValue(us);
        }
        else{
            Toast.makeText(getApplication(), "No hay datos", Toast.LENGTH_LONG).show();
        }
    }
}
