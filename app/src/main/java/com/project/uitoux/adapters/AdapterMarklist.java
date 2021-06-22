 package com.project.uitoux.adapters;

 import android.content.Context;
 import android.content.DialogInterface;
 import android.graphics.Paint;
 import android.os.Vibrator;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.Button;
 import android.widget.EditText;
 import android.widget.ImageView;
 import android.widget.LinearLayout;
 import android.widget.TextView;

 import androidx.appcompat.app.AlertDialog;
 import androidx.recyclerview.widget.RecyclerView;


 import com.project.uitoux.Constants;
 import com.project.uitoux.R;
 import com.project.uitoux.model.Model;

 import java.math.BigDecimal;
 import java.math.RoundingMode;
 import java.util.List;

 public class AdapterMarklist extends RecyclerView.Adapter<AdapterMarklist.ViewHolderClass> {


     Context context;
     List<Model> list;





     //List<DetailsItem_no_stock> list_stock_prob_items;

     public AdapterMarklist(Context context, List<Model> list) {
         this.context = context;
         this.list = list;

     }

     @Override
     public ViewHolderClass onCreateViewHolder(ViewGroup parent, int viewType) {

         LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         View view = inflater.inflate(R.layout.model_mark_row, parent, false);
         //   view.findViewById(R.id.txt1).setMinimumHeight(560);
         // view.setMinimumHeight(160);
         //   View rootView = LayoutInflater.from(context).inflate(R.layout.itemLayout, parent, false);
         return new ViewHolderClass(view);

     }

     @Override
     public void onBindViewHolder(ViewHolderClass holder, int position) {


         final Model cpr = list.get(position);



         holder.txtname.setText(cpr.getName());
         holder.edtm1.setText(String.valueOf(cpr.getMark1()));
         holder.edtm2.setText(String.valueOf(cpr.getMark2()));
         holder.edtm3.setText(String.valueOf(cpr.getMark3()));
         holder.txttotal.setText(String.valueOf(cpr.getTotal()));
         holder.txtrank.setText(String.valueOf(cpr.getRank()));

         holder.btnsave.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int m1=0,m2=0,m3=0;

                 try{
                     m1=    Integer.parseInt(  holder.edtm1.getText().toString().trim());
                 }
                 catch (Exception e)
                 {
                     m1=0;
                 }
                 try{
                     m2=    Integer.parseInt(  holder.edtm2.getText().toString().trim());
                 }
                 catch (Exception e)
                 {
                     m2=0;
                 }

                 try{
                     m3=    Integer.parseInt(  holder.edtm3.getText().toString().trim());
                 }
                 catch (Exception e)
                 {
                     m3=0;
                 }

                 Constants.getMainActivityInterface().update_marks(cpr.getStd_id(),m1,m2,m3);
             }
         });

     }

     @Override
     public int getItemCount() {
         return list.size();
     }


     public class ViewHolderClass extends RecyclerView.ViewHolder {



         TextView txtname,txttotal,txtrank;
         EditText edtm1,edtm2,edtm3;
         Button btnsave;
         public ViewHolderClass(View itemView) {
             super(itemView);



             txtname = itemView.findViewById(R.id.txtname);
             edtm1 = itemView.findViewById(R.id.edtm1);
             edtm2 = itemView.findViewById(R.id.edtm2);
             edtm3 = itemView.findViewById(R.id.edtm3);
             txttotal = itemView.findViewById(R.id.txttotal);
             txtrank= itemView.findViewById(R.id.txtrank);
             btnsave= itemView.findViewById(R.id.btnsave);








         }
     }




 }
