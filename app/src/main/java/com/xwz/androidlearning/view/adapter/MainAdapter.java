package com.xwz.androidlearning.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.xwz.androidlearning.R;
import com.xwz.androidlearning.databinding.ItemMainBinding;
import com.xwz.androidlearning.model.MainModel;
import com.xwz.androidlearning.viewmodel.ItemMainViewModel;

import java.util.Collections;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder> {

    private List<MainModel> mainModelList;

    public MainAdapter(){
        this.mainModelList = Collections.emptyList();
    }

    @NonNull
    @Override
    public MainAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMainBinding itemMainBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_main, parent, false);
        return new MainAdapterViewHolder(itemMainBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainAdapterViewHolder holder, int position) {
        holder.bindMainModel(mainModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return mainModelList.size();
    }

    public void setMainModelList(List<MainModel> mainModelList) {
        this.mainModelList = mainModelList;
        notifyDataSetChanged();
    }

    static class MainAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemMainBinding binding;

        MainAdapterViewHolder(ItemMainBinding binding) {
            super(binding.itemMain);
            this.binding = binding;
        }

        void bindMainModel(MainModel mainModel) {
            if (binding.getMainViewModel() == null) {
                binding.setMainViewModel(new ItemMainViewModel(itemView.getContext(), mainModel));
            } else {
                binding.getMainViewModel().setMainModel(mainModel);
            }
        }
    }
}