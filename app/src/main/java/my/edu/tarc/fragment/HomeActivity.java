package my.edu.tarc.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import my.edu.tarc.fragment.Database.BihuaData;
import my.edu.tarc.fragment.Database.UserDataSource;

public class HomeActivity extends AppCompatActivity {
    ListView lv;
    Context context;
    Intent intent;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.learning,R.drawable.survival,R.drawable.test,R.drawable.about};
    public static String [] prgmNameList={"LEARNING","SURVIVAL CHINESE","MOCK TEST","ABOUT APP"};
    public static String [] subList={"Learn chinese material","All in hand","Test your skill","App developer information"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        saveRecord();

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages,subList));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    intent = new Intent(HomeActivity.this, LearningActivity.class);
                }
                if(position == 1){
                    //intent = new Intent(HomeActivity.this, SurvChineseActivity.class);
                }
                if(position == 2){
                    intent = new Intent(HomeActivity.this, ExamActivity.class);
                }
                if(position == 3){
                    intent = new Intent(HomeActivity.this, AboutActivity.class);
                }
                startActivity(intent);

            }
        });
    }

    public void saveRecord(){
        UserDataSource userDataSource = new UserDataSource(this);
        userDataSource.open();
        userDataSource.delete();

        String[] id = {"男","女","笑","鸡","天","土","车","马","狗","羊"};
        int[] images = {R.drawable.nan, R.drawable.nan, R.drawable.nan, R.drawable.nan, R.drawable.nan, R.drawable.nan, R.drawable.nan, R.drawable.nan, R.drawable.nan, R.drawable.nan};
        String[] pinbi = {
                "拼音 :  Nán\n笔画 :  共七画",
                "拼音 :  nǚ\n笔画 :  共三画",
                "拼音 :  xiào\n笔画 :  共十画",
                "拼音 :  jī\n笔画 :  共七画",
                "拼音 :  tiān\n笔画 :  共四画",
                "拼音 :  tǔ\n笔画 :  共三画",
                "拼音 :  chē\n笔画 :  共四画",
                "拼音 :  mǎ\n笔画 :  共三画",
                "拼音 :  gǒu\n笔画 :  共八画",
                "拼音 :  yáng\n笔画 :  共六画"
        };
        String[] zhuci = {
                "男孩\n男人",
                "女孩\n女人",
                "笑颜\n笑容",
                "公鸡\n母鸡",
                "天空\n天气",
                "黄土\n土地",
                "马车\n火车",
                "大马\n马到成功",
                "走狗\n狗盗",
                "绵羊\n黄羊"
        };
        String[] detail ={
                "男 (he; male; son )\n〈名〉\n(1) (会意。从田,从力。表示用力(一说指耒)在田间耕作。本义:男人,与“女”相对)\n\n(2) 同本义 [man]\n\n(3) 又如:男事(古指成年男子应尽的职责);男夫(成年男子);男圻(犹男服);男教(对男子的教化);男德(有德行的男子);男权(男子在家庭、社会中的支配性特权)\n\n(4) 引申为儿子 [boy;son]",
                "女 (she; woman; daughter )\n〈名〉\n(1) (象形。甲骨文字形,象一个敛手跪着的人形。本义:女性, 女人,与“男”相对)\n\n(2) 同本义 [woman]\n\n(3) 又如:女陪堂(女帮闲);女先儿(女先生);女红(泛指妇女干的纺织、缝纫、刺绣等);女冠(女道士);女兄(姐姐);女伯(称父亲的姐姐);女嬖(受君主宠爱的女人);女隶(女官。被没入宫中为奴的女子);女中丈夫(女子中有男子气概的人)\n\n(4) 引申指女儿 [daughter]",
                "笑 (smile; laugh; giggle )\n〈名〉\n(1) (会意。从竹,从夭。杨承庆曰,“竹得风其体夭屈,如人之笑”。字或从竹,从夭。本义:因喜悦开颜或出声)\n\n(2) 同本义 [smile]\n\n(3) 又如:笑唏唏(笑嘻嘻);笑咍咍(大声地笑);笑浪(无拘束地大笑);笑面夜叉(外貌和气、心地狠毒的人)\n\n(4) 引申指嘲笑 [ridicule]",
                "鸡 (chook; chicken )\n〈名〉\n(1) (形声。从鸟,奚声。本义:家禽名。雄鸡可以报晓) 鸟纲雉科家禽,品种很多,喙短锐,有冠与肉髯,翅膀短,尤指普通家鸡\n\n(2) 同本义 [chicken]\n\n(3) 又如:鸡男(雄鸡);鸡坊(养鸡场);鸡肤(鸡皮。比喻皮肤粗糙而多皱纹);鸡鹜(鸡和鸭)\n\n(4) 引申指普通家鸡 [Gallus gallus]",
                "天 (day; sky)\n〈名〉\n(1) (会意。甲骨文字形。下面是个正面的人形(大),上面指出是人头,小篆变成一横。本义:人的头顶)\n\n(2) 同本义 [top]\n\n(3) 又如:天灵(人或其他动物的头顶骨);天灵盖(头顶骨)\n\n(4) 引申指天空 [sky]",
                "土 (land; soil)\n〈名〉\n(1) (象形。甲骨文字形,上象土块,下象地面。金文中空廓变填实,小篆又变为线条。本义:泥土,土壤)\n\n(2) 同本义 [soil]\n\n(3) 又如:土粉(粉刷墙壁用的白垩土);土力(土壤肥沃的程度);土化(施肥使土壤肥沃)\n\n(4) 引申指土地 [land;ground]",
                "车 (cart; car)\n〈名〉\n(1)(象形。甲骨文有多种写法。象车形。本义:车子,陆地上有轮子的运输工具)\n\n(2) 同本义 [vehicle]\n\n(3) 又如:开车;安步当车;杯水车薪;闭门造车;螳臂当车;车两 (古谓车一乘为一两);车盖(古代车上的伞形车篷。\n\n(4)特指战车,兵车 [chariot]",
                "马 (horse; steed)\n〈名〉\n(1)(象形。早期金文字形,象马眼、马鬃、马尾之形。“马”是汉字的一个部首。\n\n(2) 同本义 [horse]\n\n(3) 又如:马伯乐(相马的人);马首(属马的人);马牌子(官府养马的伕役,他们身上都挂有腰牌作凭证)\n\n(4) 引申驾着马 [take horse;control a horse]",
                "狗 (dog; canis)\n〈名〉\n(1)(形声。从犬,句( gōu)声。本义:犬。原指小犬。后为狗犬的通称)\n\n(2) 同本义 [canine]\n\n(3)又如:狗心狗行(比喻坏心肠、恶劣行为);狗鼠(比喻品行卑劣的人)\n\n(4) 引申小狗崽 [pup;puppy]",
                "羊 (sheep; goat)\n〈名〉\n(1)(象形。甲骨文字形,像羊头形。“羊”是汉字的一个部首。本义:一种哺乳动物)\n\n(2) 同本义 [sheep]\n\n(3)又如:羊群里跑出骆驼来(喻指平常的人忽然变成了出类拔萃的人物了);羊群蚁阵(形容众多而聚集)\n\n(4)引吉利。后作“祥” [lucky]"
        };
        BihuaData bihuaData = new BihuaData();
        for(int i=0; i<zhuci.length; i++) {
            bihuaData.setId(id[i]);
            //bihuaData.setImage(images[i]);
            bihuaData.setZhuci(zhuci[i]);
            bihuaData.setDetail(detail[i]);
            bihuaData.setPinbi(pinbi[i]);
            userDataSource.insertUser(bihuaData);
        }

    }


}
