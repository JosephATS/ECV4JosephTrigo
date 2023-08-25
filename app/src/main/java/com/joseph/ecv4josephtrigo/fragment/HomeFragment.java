package com.joseph.ecv4josephtrigo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joseph.ecv4josephtrigo.R;
import com.joseph.ecv4josephtrigo.data.response.ShowResponse;
import com.joseph.ecv4josephtrigo.data.retrofit.RetrofitHelper;
import com.joseph.ecv4josephtrigo.databinding.FragmentHomeBinding;
import com.joseph.ecv4josephtrigo.model.Platos;
import com.joseph.ecv4josephtrigo.model.Shows;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RVResumeAdapter adapter = new RVResumeAdapter(getData());
        binding.blanquitaparecedeolanda.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false);
        binding.blanquitaparecedeolanda.setLayoutManager(layoutManager);

        RetrofitHelper.getService().getShows().enqueue(new Callback<ShowResponse>() {
            @Override
            public void onResponse(Call<ShowResponse> call, Response<ShowResponse> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    showMenus(response.body().getShowsList());
                }
            }

            @Override
            public void onFailure(Call<ShowResponse> call, Throwable t) {

            }
        });
    }




    private void showMenus(List<Shows> showModelList) {
        RVShowAdapter adapter = new RVShowAdapter(showModelList);
        binding.show.setAdapter(adapter);
    }
        private List<Platos> getData(){
            List<Platos>platos = new ArrayList<>();
            platos.add(new Platos("Local", "", "https://serviciosturisticos.sernatur.cl/folder/empresas/emp_76947890/inscripcion_17878/phpabK2Wa2016062106654.jpg"));
            platos.add(new Platos("", "", "https://scontent.flim38-1.fna.fbcdn.net/v/t39.30808-6/300436104_439388721543360_544879825237310778_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=09cbfe&_nc_eui2=AeHINWplPU2Fx66LrOA6UibI5Hobsb8LI_3kehuxvwsj_Zs-JZGtfk8IyI9pl28kahDwAdP5cjHvfZqzXEPhT_O0&_nc_ohc=aicqtJLIOfgAX82RGu-&_nc_ht=scontent.flim38-1.fna&oh=00_AfCPJsU_PRVkBynHusP83QHgoCUduhachOrwMu9hiE72hA&oe=64EAF45B"));
            platos.add(new Platos("", "", "https://scontent.flim38-1.fna.fbcdn.net/v/t39.30808-6/295030740_455417289924141_1835562619648970387_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=09cbfe&_nc_eui2=AeHXPCkwuZokRkDRbrDJh72KlU_It-_cbduVT8i379xt2zFBCPHGi1Do5GQ-ScxnRlonCvT7-JTuDd6QjCRYCbps&_nc_ohc=rZPQglItP_YAX-zq11b&_nc_ht=scontent.flim38-1.fna&oh=00_AfBQoSu-8pwAiZy7CPOH7bv1LJ4UV_2PdIiwCo44lbIxHQ&oe=64EC53BA"));
            platos.add(new Platos("", "", "https://lh3.googleusercontent.com/p/AF1QipM9FYJvwd8EkFWZiI8Zj4ICGzTwAUAmBmXY5AcV=w1080-h608-p-no-v0"));
            platos.add(new Platos("", "", "https://scontent.flim38-1.fna.fbcdn.net/v/t39.30808-6/306746770_535786591881730_7109093908398525811_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=09cbfe&_nc_eui2=AeEsJmOKLB9i0b4J60hngT0uGRuzKnk-uHIZG7MqeT64cs9_ZzjeQWmel87VYor2pZYJHlrUclSFtkkV3qeE5Uq4&_nc_ohc=8IbjUanAf0cAX8TIS_0&_nc_ht=scontent.flim38-1.fna&oh=00_AfBmF9SeOnch-IZdgpCCLPzIfthY8ZJ4LHTYCbaf1rVD-Q&oe=64ED7EE9"));
            platos.add(new Platos("", "", "https://scontent.flim38-1.fna.fbcdn.net/v/t39.30808-6/241933801_1224047461355868_3023399028908833092_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=09cbfe&_nc_eui2=AeHEMmYL9M1ct6KEdTEH9aQ_7v14PVQ7g-7u_Xg9VDuD7hpZdf0j9-LxB55m7GWs9ZDrqUDT5LStb4GU8q3kSq5I&_nc_ohc=7Tm-p5LVMDYAX_z6bWN&_nc_ht=scontent.flim38-1.fna&oh=00_AfDwDMPmBoDu_5OOK3Rpx_gQzFmF_-tKEliNTKvCSUauHg&oe=64ED7CAE"));


            return platos;
        }
}