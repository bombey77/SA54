package bombey77.sa54;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ромашка on 12.03.2017.
 */

public class BoxAdapter extends BaseAdapter {

    Context context;
    ArrayList <Product> objects;
    LayoutInflater lInflater;

    BoxAdapter(Context context, ArrayList <Product> products) {
        this.context = context;
        this.objects = products;
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        Product p = getProduct(position);

        ((TextView) view.findViewById(R.id.tvDescr)).setText(p.getName());
        ((TextView) view.findViewById(R.id.tvPrice)).setText(p.getPrice() + "");
        ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(p.getImage());

        CheckBox checkBox = (CheckBox) view.findViewById(R.id.cbBox);
        checkBox.setOnCheckedChangeListener(onCheckedChangeListener);
        checkBox.setTag(position);
        checkBox.setChecked(p.box);
        return view;
    }

    Product getProduct(int position) {
        return ((Product) getItem(position));
    }

    ArrayList <Product> getBox() {
        ArrayList <Product> box = new ArrayList<>();
        for (Product p : objects) {
            if (p.box){
                box.add(p);
            }
        }
        return box;
    }

    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            getProduct((Integer) buttonView.getTag()).box = isChecked;
        }
    };
}
