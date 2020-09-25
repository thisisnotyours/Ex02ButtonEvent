package com.suek.ex02buttonevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 뷰 객체들의 참조변수는 가급적 멤버변수로 만들것!!
    TextView tv;
    Button btn;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     //이때, xml 문서를 읽어서 뷰 객체들(LinearLayout, TextView, Button)을 생성함

        //MainActivity.java 문서의 setContentView( )를 activity_main.xml와 연결해 객체 생성
        //MainActivity.java 문서에서 참조변수를 이용해서  activity_main.xml 를 제어
    // xml 문서에서 만든 TextView 객체를 찾아와서 tv 참조변수로 참조하도록...-> 참조변수가 ("Hello"- TextView)의 주소를 참조한다
    tv= this.findViewById(R.id.tv);   // 뷰가 여러개 있으니까 식별자(id)를 넣어 참조해준다.(R.id.tv)여기의 tv는 R장부에 저장 (여기서 tv는 참조변수 아님)
    btn=findViewById(R.id.btn);       // this.은 생략가능
        et= findViewById(R.id.et);

        //버튼을 '클릭했을 때' 텍스트뷰의 글씨 변경!!!
        //버튼이 클릭되는 것을 듣는 리스너 객체 생성
        View.OnClickListener listener= new View.OnClickListener(){      //객체를 만들면서 클래스를 만들겟다는 의미
            //onclickListener= 이 리스너 객체가 바라보고 있는 버튼이 클릭되면 자동으로 실행되는 콜백메소드
            @Override
            public void onClick(View v) {
                //이 메소드 안에 코드를 작성하면.. 클릭되었을때 이 메소드가 실행됨.
                //tv.setText("Nice");

                // EditText에 써있는 글씨를 얻어와서
                Editable editable= et.getText();     //Editable에서 글씨를 얻어오는 방법
                String s= editable.toString();

                //얻어 온 글씨를 TextView 에 설정하기
                tv.setText(s);
            }
        };
        //위에서 만든 리스너 객체를 버튼에게 설정
        btn.setOnClickListener(listener);    //여기에있는 btn 은 '리스너 객체가 바라보고 있는 버튼임'

    }
}
