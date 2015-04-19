package com.example.listado3;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends Activity {
	
	private ListView lista; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);

        
        ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  
        
        datos.add(new Lista_entrada(R.drawable.im_amanecer, "Amanecer", "El matrimonio de Bella y su luna de miel con Edward en una isla privada de la costa de Brasil. Edward le concede su deseo a Bella y se acuestan juntos. Poco después, se da cuenta de que está embarazada, preocupado por su bienestar, la insita a abortar ya que el bebé se alimenta de la energía de Bella. Sin embargo, ella quiere quedarse con el niño y decide pedir ayuda a Rosalie que siempre quiso ser madre. "));
        datos.add(new Lista_entrada(R.drawable.im_bendecida,  "Bendecida_Sombra", " ¿Qué ocurriría si tuvieras que elegir entre tu mejor amiga y la persona a la que amas? Rose sabe que enamorarse de otro guardián está prohibido. Su mejor amiga, la última princesa Dragomir, siempre debe ser su prioridad."));
        datos.add(new Lista_entrada(R.drawable.im_crepusculo, "Crepusculo", "La historia Bella lee la carta de Jacob, continúa su relación con Edward haciendo caso omiso a las opiniones de los demás. Los Cullen se dan cuenta de que los Vulturi se van a enterar del ejército de neófitos. Edward le propone matrimonio a Bella con el anillo de compromiso de su madre. Bella acepta."));
        datos.add(new Lista_entrada(R.drawable.im_deuda, "Deuda_Espiritu", "Rose Hathaway regresa por fin a la Academia St. Vladimir. Allí retomará su vida como estudiante y volverá a ver a su mejor amiga, Lissa. Dimitri ha probado su sangre y tratará por todos los medios de dar caza a Rose. No parará hasta que ella se una a él para siempre."));
        datos.add(new Lista_entrada(R.drawable.im_eclipse, "Eclipse", "Bella se encuentra de nuevo en peligro: una serie de misteriosos asesinatos está sembrando el pánico en la localidad y hay un ser maligno tras ella, sediento de ven ganza. Además, tendrá que elegir entre su amor por Edward y su amistad con Jacob, consciente de que su decisión podrá desencadenar definitivamente la guerra entre vampiros y hombres lobo."));
        
        datos.add(new Lista_entrada(R.drawable.im_lunanueva, "Luna_Nueva", "El cumpleaños número dieciocho de Bella, los Vulturi advierten que deben transformar a Bella, porque esta sabe su secreto. Edward le confiesa a Bella que nunca la ha dejado de amar y le pone como condición a Bella que él la transformará en vampiro, si ella acepta casarse con él."));
        
        datos.add(new Lista_entrada(R.drawable.im_promesa, "Promesa_Sangre", "El resto del mundo había considerado que ha Dimitri muerto.La vida de la Guardiana Rose Hattaway nunca volverá a ser la misma.El reciente ataque a la Academia de San Vladimir devastó el mundo Moroi. Ahora Rose debe escoger uno de los dos caminos: la honra del voto de su vida para proteger a Lissa o, perseguir al hombre que ama."));
        //datos.add(new Lista_entrada(R.drawable.im_sangre, "Sangre_Azul", "Rose Hathaway tiene un problema con su tutor Dimitri, su amigo Mason colado por ella y el vínculo telepático que tiene con su mejor amiga la vuelve loca cuando ésta se enrolla con su novio, Christian. Entonces un gran ataque Strigoi pone en alerta a la Academia. Cuando 3 estudiantes escapan para contraatacar a los mortales strigoi, Rose tendrá que unir sus fuerzas con las de Christian para rescatarlos."));
        
        
        
        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos){
			@Override
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima()); 
		              
		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoDebajo()); 
		              
		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
		        }
			}
		});
        
        
        
        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				//setContentView(R.layout.listado);
				
				Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion); 
				
				/*String texto = "Seleccionado: " + elegido.get_textoDebajo();
				CharSequence imagen = "Seleccionado: " + elegido.get_idImagen();
                Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();
				*/
                enviarDatos(pariente, view,posicion,id);

				
			}
			
        });
      
        
        
    }
    public void enviarDatos(AdapterView<?> pariente, View view, int posicion, long id){
    	Intent intent = new Intent(this, ActididadActivity.class );
    	Lista_entrada item = (Lista_entrada) lista.getAdapter().getItem(posicion);
    	intent.putExtra("imagen",item.get_idImagen());
    	intent.putExtra("debajo",item.get_textoDebajo().toString());
    	intent.putExtra("encima",item.get_textoEncima().toString()); 
        startActivity(intent);
    }
    
}
