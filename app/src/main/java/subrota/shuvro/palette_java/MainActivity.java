package subrota.shuvro.palette_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Palette.Swatch vibrantSwatch;
    private Palette.Swatch darkVibrantSwatch;
    private Palette.Swatch lightVibrantSwatch;
    private Palette.Swatch mutedSwatch;
    private Palette.Swatch darkMutedSwatch;
    private Palette.Swatch lightMutedSwatch;

    private int swatchNumber;

    private TextView title, body;
    private ConstraintLayout rootLayout;
    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        body = findViewById(R.id.body);
        imageView = findViewById(R.id.imageView);
        rootLayout = findViewById(R.id.rootLayout);
        button = findViewById(R.id.button);

        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated( Palette palette) {
                vibrantSwatch = palette.getVibrantSwatch();
                darkVibrantSwatch = palette.getDarkVibrantSwatch();
                lightVibrantSwatch = palette.getLightVibrantSwatch();
                mutedSwatch = palette.getMutedSwatch();
                darkMutedSwatch = palette.getDarkMutedSwatch();
                lightMutedSwatch = palette.getLightMutedSwatch();

                rootLayout.setBackgroundColor(darkMutedSwatch.getRgb());
                title.setTextColor(palette.getVibrantColor(getResources().getColor(R.color.black)));
                //body.setTextColor(lightVibrantSwatch.getRgb());
                body.setTextColor(getResources().getColor(R.color.white));
                button.setBackgroundColor(vibrantSwatch.getRgb());

            }
        });
    }

    public void changeColor(View view) {
        view.setBackgroundColor(vibrantSwatch.getRgb());
    }
}