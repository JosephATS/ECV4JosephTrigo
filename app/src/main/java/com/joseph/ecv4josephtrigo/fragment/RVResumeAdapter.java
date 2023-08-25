package com.joseph.ecv4josephtrigo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joseph.ecv4josephtrigo.databinding.ItemShowResumeBinding;
import com.joseph.ecv4josephtrigo.model.Platos;
import com.joseph.ecv4josephtrigo.model.Shows;

import java.util.List;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class RVResumeAdapter  extends RecyclerView.Adapter<RVResumeAdapter.ResumeVH> {
    private List<Platos> platos;


    public RVResumeAdapter(List<Platos> platos) {
        this.platos = platos;
    }

    @NonNull
    @Override
    public ResumeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemShowResumeBinding binding = ItemShowResumeBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ResumeVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeVH holder, int position) {
        holder.bind(platos.get(position));
    }

    @Override
    public int getItemCount(){
        return platos.size();
    }



    class ResumeVH extends RecyclerView.ViewHolder{

        private ItemShowResumeBinding binding;
        public ResumeVH(ItemShowResumeBinding binding){
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bind(Platos platos) {
            if(platos instanceof Platos){
                binding.texto1.setText(platos.getTitulo());
                binding.texto2.setText(platos.getNombre());
            }

            ImageLoader imageLoader= Coil.imageLoader(binding.getRoot().getContext());
            ImageRequest request = new ImageRequest.Builder(binding.getRoot().getContext())
                    .data(platos.getUrl())
                    .crossfade(true)
                    .target(binding.imagen3)
                    .build();
            imageLoader.enqueue(request);

        }
    }
}