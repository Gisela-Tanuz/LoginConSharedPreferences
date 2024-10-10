package ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.loginconsharedpreferences.databinding.ActivityMainBinding;

import model.Usuario;
import ui.registros.RegistrosActivity;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private MainActivityViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
      vm.getOk().observe(this, new Observer<Integer>() {
      @Override
      public void onChanged(Integer integer) {
        binding.tvError.setVisibility(integer);
    }
   });


        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = binding.etUsuario.getText().toString();
                String pass  = binding.etPass.getText().toString();
                vm.login(mail,pass);
            }
        });
        binding.btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistrosActivity.class);
                startActivity(intent);
            }
        });

    }
}
