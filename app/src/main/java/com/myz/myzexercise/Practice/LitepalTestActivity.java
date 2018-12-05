package com.myz.myzexercise.Practice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.myz.myzexercise.R;

import org.litepal.LitePal;

import java.io.ByteArrayOutputStream;
import java.util.List;

import bean.Picture;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LitepalTestActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1001;

    @BindView(R.id.btn_take_photo)
    Button btnTakePhoto;
    @BindView(R.id.rv_test)
    RecyclerView rvTest;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litepal_test);
        ButterKnife.bind(this);
        List<Picture> pictures = LitePal.findAll(Picture.class);
        adapter = new Adapter(pictures);
        rvTest.setAdapter(adapter);
        rvTest.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnItemChildClickListener((adapter, view, position) -> {
            Picture picture =  (Picture)adapter.getItem(position);
            LitePal.deleteAll(Picture.class,"title like ?",picture.getTitle());
            adapter.setNewData(LitePal.findAll(Picture.class));
        });
    }


    @OnClick(R.id.btn_take_photo)
    public void onViewClicked() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            try {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                byte[] images = Bitmap2byte(photo);
                Picture picture = new Picture();
                picture.setTitle(adapter.getData().size() + "");
                picture.setImageBt(images);
                ToastUtils.showShort(picture.save() ? "success!!" : "error");
                List<Picture> list = LitePal.findAll(Picture.class);
                adapter.setNewData(list);
            } catch (Exception e) {

            }

        }
    }

    private byte[] Bitmap2byte(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    @OnClick(R.id.btn_del)
    public void onViewClicked2() {
        LitePal.deleteAll(Picture.class);
        adapter.setNewData(LitePal.findAll(Picture.class));
    }

    private static class Adapter extends BaseQuickAdapter<Picture, BaseViewHolder> {

        public Adapter(@Nullable List<Picture> data) {
            super(R.layout.item_picture, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Picture item) {
            helper.setText(R.id.title, "title:" + item.getTitle());
            Bitmap bitmap = BitmapFactory.decodeByteArray(item.getImageBt(), 0, item.getImageBt().length);
            helper.setImageBitmap(R.id.img, bitmap);
            helper.addOnClickListener(R.id.del);
        }
    }

}
