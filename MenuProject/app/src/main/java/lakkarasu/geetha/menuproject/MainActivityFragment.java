package lakkarasu.geetha.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button sms = (Button) view.findViewById(R.id.sms_btn);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+ Uri.encode("2345678901")));
                intent.putExtra("sms_body","Geetha Lakkarasu");
                startActivity(intent);
            }
        });

        Button phone = (Button) view.findViewById(R.id.phone_btn);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + "9176903626"));
                startActivity(callIntent);
            }
        });

        Button web = (Button) view.findViewById(R.id.web_btn);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String linkURL = "https://www.google.com/imgres?imgurl=https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Empire_State_Building_%2528HDR%2529.jpg/150px-Empire_State_Building_%2528HDR%2529.jpg&imgrefurl=https://en.wikipedia.org/wiki/New_York_City&h=222&w=150&tbnid=6wpVb5Sy4vXJIM:&q=newyork&tbnh=160&tbnw=108&usg=__SLc735o6WqyRjAluIt8zlOrmokA%3D&vet=10ahUKEwiZw4eszNnbAhVOj1kKHUDxClgQ_B0I4gEwEg..i&docid=CNXi28oHbZhMkM&itg=1&sa=X&ved=0ahUKEwiZw4eszNnbAhVOj1kKHUDxClgQ_B0I4gEwEg#h=222&imgdii=zAgW0NCLrzykbM:&tbnh=160&tbnw=108&vet=10ahUKEwiZw4eszNnbAhVOj1kKHUDxClgQ_B0I4gEwEg..i&w=150";
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkURL));
                startActivity(webIntent);
            }
        });

        Button map = (Button) view.findViewById(R.id.map_btn);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String birthPlaceURL = "https://www.google.com/maps/place/Hyderabad,+Telangana,+India/@17.4128084,78.1278409,10z/data=!3m1!4b1!4m5!3m4!1s0x3bcb99daeaebd2c7:0xae93b78392bafbc2!8m2!3d17.385044!4d78.486671";
                Intent mapintent = new Intent(Intent.ACTION_VIEW,Uri.parse(birthPlaceURL));
                startActivity(mapintent);

            }
        });

        Button share = (Button) view.findViewById(R.id.share_btn);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"Share the love"));
            }
        });

        return view;
    }
}
