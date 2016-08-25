package my.edu.tarc.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

import my.edu.tarc.fragment.Database.BihuaData;
import my.edu.tarc.fragment.Database.UserDataSource;

public class HomeActivity extends AppCompatActivity {
    ListView lv;
    Context context;
    Intent intent;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.learning,R.drawable.survival,R.drawable.test,R.drawable.about};
    public static String [] prgmNameList;
    public static String [] subList;
    AlertDialog.Builder alertDialogBuilder;
    public static boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        saveRecord();



        prgmNameList = getResources().getStringArray(R.array.hometitle_name);
        subList = getResources().getStringArray(R.array.homesubtitle_name);

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages,subList));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    intent = new Intent(HomeActivity.this, LearningActivity.class);
                    startActivity(intent);
                }
                else if(position == 1){
                    intent = new Intent(HomeActivity.this, SurvChineseActivity.class);
                    startActivity(intent);
                }
                else if(position == 2){
                    if(clicked == false) {
                        alertDialogBuilder = new AlertDialog.Builder(HomeActivity.this);
                        alertDialogBuilder.setMessage(getResources().getString(R.string.confirmation));

                        alertDialogBuilder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                clicked = true;
                                intent = new Intent(HomeActivity.this, ExamActivity.class);
                                startActivity(intent);

                            }
                        });

                        alertDialogBuilder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                clicked = false;
                            }
                        });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }else{
                        intent = new Intent(HomeActivity.this, ExamActivity.class);
                        startActivity(intent);
                    }
                }
                else{
                    intent = new Intent(HomeActivity.this, AboutActivity.class);
                    startActivity(intent);
                }


            }
        });
    }

    public void saveRecord(){
        UserDataSource userDataSource = new UserDataSource(this);
        userDataSource.open();
        userDataSource.delete();

        String[] id = {"男","女","笑","鸡","天","土","车","马","狗","羊", "打", "读", "放", "飞", "喝", "滑", "跑", "跳", "玩", "游", "俊", "克", "孔", "裤", "绿", "傻", "图", "袖", "选", "载"};
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
                "拼音 :  yáng\n笔画 :  共六画",
                "拼音 :  dǎ\n笔画 :  共五画",
                "拼音 :  dú\n笔画 :  共十画",
                "拼音 :  fàng\n笔画 :  共八画",
                "拼音 :  fēi\n笔画 :  共三画",
                "拼音 :  hē\n笔画 :  共十二画",
                "拼音 :  huá\n笔画 :  共十二画",
                "拼音 :  pǎo\n笔画 :  共十二画",
                "拼音 :  tiào\n笔画 :  共十三画",
                "拼音 :  wán\n笔画 :  共八画",
                "拼音 :  yóu\n笔画 :  共十二画",
                "拼音 :  jùn\n笔画 :  共九画",
                "拼音 :  kè\n笔画 :  共七画",
                "拼音 :  kǒng\n笔画 :  共四画",
                "拼音 :  kù\n笔画 :  共十二画",
                "拼音 :  lǜ\n笔画 :  共十一画",
                "拼音 :  shǎ\n笔画 :  共十三画",
                "拼音 :  tú\n笔画 :  共八画",
                "拼音 :  xiù\n笔画 :  共十一画",
                "拼音 :  xuǎn\n笔画 :  共九画",
                "拼音 :  zài\n笔画 :  共十画"
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
                "绵羊\n黄羊",
                "打架\n打击",
                "读书\n朗读",
                "放电\n流放",
                "飞机\n飞翔",
                "喝茶\n喝水",
                "滑冰\n下滑",
                "跑步\n赛跑",
                "跳远\n跳高",
                "玩爽\n玩水",
                "游泳\n梦游",
                "英俊\n俊美",
                "克服\n克色",
                "孔子\n毛孔",
                "底裤\n裤子",
                "绿色\n绿帽",
                "傻瓜\n傻笑",
                "图画\n图书馆",
                "袖子\n衣袖",
                "选手\n选美",
                "载客\n装载"
        };
        String[] detail ={
                "男 (he; male; son )\n〈名〉\n(1) (会意。从田,从力。表示用力(一说指耒)在田间耕作。本义:男人,与“女”相对)\n\n(2) 同本义 [man]\n\n(3) 又如:男事(古指成年男子应尽的职责);男夫(成年男子);男圻(犹男服);男教(对男子的教化)\n\n(4) 引申为儿子 [boy;son]",
                "女 (she; woman; daughter )\n〈名〉\n(1) (象形。甲骨文字形,象一个敛手跪着的人形。本义:女性, 女人,与“男”相对)\n\n(2) 同本义 [woman]\n\n(3) 又如:女陪堂(女帮闲);女先儿(女先生);女隶(女官。被没入宫中为奴的女子)\n\n(4) 引申指女儿 [daughter]",
                "笑 (smile; laugh; giggle )\n〈名〉\n(1) (会意。从竹,从夭。杨承庆曰,“竹得风其体夭屈,如人之笑”。字或从竹,从夭。本义:因喜悦开颜或出声)\n\n(2) 同本义 [smile]\n\n(3) 又如:笑唏唏(笑嘻嘻);笑咍咍(大声地笑);笑浪(无拘束地大笑);笑面夜叉(外貌和气、心地狠毒的人)\n\n(4) 引申指嘲笑 [ridicule]",
                "鸡 (chook; chicken )\n〈名〉\n(1) (形声。从鸟,奚声。本义:家禽名。雄鸡可以报晓) 鸟纲雉科家禽,品种很多,喙短锐,有冠与肉髯,翅膀短,尤指普通家鸡\n\n(2) 同本义 [chicken]\n\n(3) 又如:鸡男(雄鸡);鸡坊(养鸡场);鸡肤(鸡皮。比喻皮肤粗糙而多皱纹);鸡鹜(鸡和鸭)",
                "天 (day; sky)\n〈名〉\n(1) (会意。甲骨文字形。下面是个正面的人形(大),上面指出是人头,小篆变成一横。本义:人的头顶)\n\n(2) 同本义 [top]\n\n(3) 又如:天灵(人或其他动物的头顶骨);天灵盖(头顶骨)\n\n(4) 引申指天空 [sky]",
                "土 (land; soil)\n〈名〉\n(1) (象形。甲骨文字形,上象土块,下象地面。金文中空廓变填实,小篆又变为线条。本义:泥土,土壤)\n\n(2) 同本义 [soil]\n\n(3) 又如:土粉(粉刷墙壁用的白垩土);土力(土壤肥沃的程度);土化(施肥使土壤肥沃)\n\n(4) 引申指土地 [land;ground]",
                "车 (cart; car)\n〈名〉\n(1) (象形。甲骨文有多种写法。象车形。本义:车子,陆地上有轮子的运输工具)\n\n(2) 同本义 [vehicle]\n\n(3) 又如:开车;安步当车;杯水车薪;闭门造车;螳臂当车;车两 (古谓车一乘为一两);车盖(古代车上的伞形车篷。\n\n(4) 特指战车,兵车 [chariot]",
                "马 (horse; steed)\n〈名〉\n(1) (象形。早期金文字形,象马眼、马鬃、马尾之形。“马”是汉字的一个部首。\n\n(2) 同本义 [horse]\n\n(3) 又如:马伯乐(相马的人);马首(属马的人);马牌子(官府养马的伕役,他们身上都挂有腰牌作凭证)\n\n(4) 引申驾着马 [take horse;control a horse]",
                "狗 (dog; canis)\n〈名〉\n(1) (形声。从犬,句( gōu)声。本义:犬。原指小犬。后为狗犬的通称)\n\n(2) 同本义 [canine]\n\n(3) 又如:狗心狗行(比喻坏心肠、恶劣行为);狗鼠(比喻品行卑劣的人)\n\n(4) 引申小狗崽 [pup;puppy]",
                "羊 (sheep; goat)\n〈名〉\n(1) (象形。甲骨文字形,像羊头形。“羊”是汉字的一个部首。本义:一种哺乳动物)\n\n(2) 同本义 [sheep]\n\n(3) 又如:羊群里跑出骆驼来(喻指平常的人忽然变成了出类拔萃的人物了);羊群蚁阵(形容众多而聚集)\n\n(4) 引吉利。后作“祥” [lucky]",
                "打 (strike; hit)\n〈动〉\n(1) (形声。从手,丁声。本义:击)\n\n(2) 同本义 [strike;hit]\n\n(3) 殴打;斗殴。亦指武术表演或戏剧中的武打 [beat up;hit;exchange blows]。如:打捶(打架);打孽(报仇,械斗);打把子(练武功)\n\n(4) 射击 [shoot at]。如:打冷枪;打炮",
                "读 (read)\n〈动〉\n(1) (形声。从言,卖声。本义:读书)\n\n(2) 籀书,抽释理解书的意义 [chant]\n\n(3) 又如:读法(诵读法令);读祝(祭祀时宣读祈祷文);读鞫(审判时,宣读起诉理由)\n\n(4) 上学 [attend]。如:读大学;走读;半工半读",
                "放 (expand)\n〈动〉\n(1) (形声。从攴( pū),方声。本义:驱逐,流放)\n\n(2) 解除约束;释放 [free;release]\n\n(3) 又如:流放(把犯人驱逐到边远地方去);放伐(以武力讨伐并放逐暴君);放徒(放野。放逐于野);放远(远逐);放废(放逐罢黜);放迁(放逐)\n\n(4) 舍弃;废置",
                "飞 (fly)\n〈动〉\n(1) (象形。小篆字形,下面象展开的双翼,上面象鸟首。本义:鸟飞)\n\n(2) 同本义 [(bird) fly]\n\n(3) 又如:飞凫(飞翔的凫鸟);飞翰(飞翔的小鸟);飞鸿(飞翔中的鸿雁)\n\n(4) 又如:飞虫(能飞的昆虫类);飞蝗(指善飞的蝗虫);飞鱼钩(叉鱼的钩子)",
                "喝 (drink)\n〈动〉\n(1) 用以表示惊讶。同“嗬” [oh]\n\n(2) (形声。从口,曷声。( yè)本义:声音幽咽。如:嘶喝。又指饮。特指饮酒) 饮。北方称饮为喝 [drink]。如:喝水;喝茶;喝汤;喝咖啡\n\n(3) 又如:呼幺喝六;喝神弄鬼(形容大喊大叫);喝号(大声吆喝);喝拳(高声划拳);喝报(大声报告);喝喊(呼喊)",
                "滑 (smooth; slippery)\n〈形〉\n(1) (形声。从水,骨声。本义:滑溜,光滑)\n\n(2) 又如:滑擦(滑擦擦。形容很光滑);滑出律(形容光滑);滑踏(滑溜;不便行走);滑刺溜(形容非常光滑)\n\n(3) 流利;婉转 [fluent]。如:滑辣(形容水响的声音);滑熟(熟练;惯熟);滑怏(形容关系融洽或没隔阂);滑串流口(谓人言词流利便捷)\n\n(4) 浮华不实 [showy]",
                "跑 (run)\n〈动〉\n(1) 又如:逃跑(逃走);别让特务跑了;跑走(逃走;走掉)\n\n(2) 逃走;躲避 [escape]\n\n(3) 又如:长跑(长距离跑步);跑解马(表演马术);跑冰(滑冰;溜冰);跑竹马(民间娱乐活动之一种);跑搭(奔走,奔忙);跑路(奔走);跑踏(奔走;奔忙)\n\n(4) 急走 [run] 跑,趵也。——《广雅·释言》",
                "跳 (jump;leap;spring)\n〈动〉\n(1) (形声。从足,兆声。本义:跃)\n\n(2) 同本义 [jump;leap;spring]\n\n(3) 又如:跳蹋(由生气或着急而顿足);跳索(杂技中的一种绳技);跳鳞(跳出水面的鱼);跳踯(上下跳跃)\n\n(4) 越过障碍 [skip over]",
                "玩 (play, enjoy)\n〈动〉\n(1) (形声。从玉,元声。本义:以手玩弄[玉])\n\n(2) 玩赏;欣赏 [enjoy;appreciate]\n\n(3) 又如:玩咏(玩赏吟咏);玩幽(玩赏幽景);玩好(玩赏与爱好);玩月(赏月)\n\n(4) 从事或投入[某种游戏或其他文娱活动] [engage in some kinds of sports or recreational activities]。如:玩戏(非专业演员演戏,玩票;耍闹,开玩笑);玩棒球;玩雪;玩适(娱乐);玩之不足(观赏不尽);玩影(弄影)",
                "放 (swim)\n〈动〉\n(1) 人或动物在水里浮行或潜泳\n\n(2) 流动,不固定 [wander about]\n\n(3) 又如:游衍(游游衍衍。游荡;游乐;干干停停,拖延时间);游花插趣(游荡作乐);游回磨转(团团转);游行(到处漫游)\n\n",
                "俊 (elite)\n〈名〉\n(1) (形声。从人,雋( jùn)声。本义:才智超群的人)\n\n(2) 同本义 [elite]\n\n(3) 又如:俊选(俊士和选士);俊良(贤能优良之士);俊物(杰出人物);俊群(才能卓越一类人)\n\n(4) 光彩 [lustre]",
                "克 (can;be able to)\n〈动〉\n(象形。甲骨文字形,下面象肩形。整个字形,象人肩物之形。本义:胜任)\n\n(2) 同本义 [be competent]\n\n(3) 又如:克当(担当,承受);克堪(胜利);克家(能承担家事);克祚(能继承祖辈的福禄);克家子(克家儿。能继承祖业的子弟);克明(能察是非)\n\n(4) 攻下;战胜;打败 [defeat;overcome;capture]",
                "孔 (hole;opening;aperture)\n〈副〉\n(1) (象形。金文字形,象小儿食乳之形。婴儿吃奶容易过量,因以表示过甚之意。本义:甚,很)\n\n(2) 又如:钥匙孔;鼻孔;孔口(洞口);孔窍(洞孔)\n\n(3) 又如:孔亟(甚急);孔多(很多);孔明(很完备;很洁净;很鲜明);孔疚(很痛苦);孔虔(非常虔诚);孔圣(很圣明)",
                "裤 (trousers)\n〈名〉\n(1) (形声。从衣,库声。本义:裤子。古指套裤,今为成人满裆裤及小儿开裆裤的通称)\n\n(2) 同本义 [trousers]\n\n(3) 底下绛裤红鞋,鲜艳夺目",
                "绿 (green)\n〈形〉\n(1) (形声。从糸( mì),表示与线丝有关,录声。本义:青中带黄的颜色)\n\n(2) 同本义 [green]\n\n(3) 又如:水绿(浅绿色);碧绿(青绿色);绿耳(骏马名。为“周穆王”八骏之一。因其毛为绿色,故名);绿竹(绿色的竹子)\n\n(4)  颜色昏暗,乌黑色 [dark]",
                "傻 (dumb; stupid)\n〈形〉\n(1) 头脑蠢笨,不谙事理,缺乏想象力\n\n(2) 同本义 [stupid;muddleheaded]\n\n(3) 又如:傻厮(傻角。傻瓜,呆子);傻大头(傻子);傻儿凹(呆子);傻相(愚蠢可笑的样子)\n\n(4) 发呆,感觉迟钝 [dumb]。如:傻心眼(死脑筋;死心眼);傻眉弄眼(形容发呆的样子);傻里巴机(傻气);装傻",
                "图 (draw)\n〈名〉\n(1) (会意。从囗,从啚。囗( wéi),表示范围。啚( bǐ),“鄙”的本字,表示艰难。合起来表示规划一件事,需慎重考虑,相当不容易。本义:谋划,反复考虑)\n\n(2) 摹拟 [imitate]\n\n(3) 又如:图形(画出人的相貌);图工(善于绘画的人);图画(描绘人或物的形像)",
                "袖 (sleeve)\n〈名〉\n(1) (古字作褎。形声。从衣,由声。本义:衣袖)\n\n(2) 袖口 [cuff]\n\n(3) 又如:袖搭(衣袖多由两片布料缝合而成,靠近袖口的一截称为袖搭);袖佉(袖子的边口)",
                "选 (choose; select)\n〈动〉\n(1) (形声。从辵( chuò),巽( xùn)声。本义:遣送;放遂)\n\n(2)  假借为“柬”。挑选,选择 [pick and choose;select]\n\n(3) 又如:选侍(选入宫中的侍女);选锋(挑选出来的精壮兵卒);选刷(挑选);选人(选用人才);选士(挑选人才);选权(铨选官吏之权);选簿(铨选官吏的簿籍);选职(主管铨选官吏的职务)\n\n(4) 派遣;使令 [dispatch]",
                "载 (ride)\n〈动〉\n(1) (形声。本义:乘坐)\n\n(2) 同本义 [ride]\n\n(3) 又如:搭载;载舟(乘船);载车(乘车)\n\n(4) 又如:载地(承载大地);载福(承受福祉);载舟覆舟(以民心向背喻水,帝王为舟,水可载舟覆舟,以此来警戒帝王须随时注意民心向背)",

        };

        String[] imagepath = {
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestnan,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestnv,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestxiao,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestji,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latesttian,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latesttu,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestche,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestma,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestgou,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestyang,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestnan,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestnv,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestxiao,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestji,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latesttian,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latesttu,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestche,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestma,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestgou,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestyang,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestnan,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestnv,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestxiao,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestji,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latesttian,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latesttu,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestche,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestma,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestgou,
                "android.resource://my.edu.tarc.fragment/"+R.raw.latestyang};

        BihuaData bihuaData = new BihuaData();
        for(int i=0; i<zhuci.length; i++) {
            bihuaData.setId(id[i]);
            bihuaData.setZhuci(zhuci[i]);
            bihuaData.setDetail(detail[i]);
            bihuaData.setPinbi(pinbi[i]);
            bihuaData.setPath(imagepath[i]);
            userDataSource.insertUser(bihuaData);
        }

    }


}

