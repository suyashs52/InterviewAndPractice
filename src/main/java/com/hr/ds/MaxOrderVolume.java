package com.hr.ds;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MaxOrderVolume {
	public static void main(String... yx) {
		Integer[] x = new Integer[] {348166839, 348166839, 39711516, 390986263, 200428421, 850830687, 57032189, 910108332,
				507610833, 869558081, 429611463, 919038339, 115343754, 339708998, 923264989, 908729662, 266138535,
				827989921, 324381919, 135067309, 660020417, 848923214, 760873069, 938741197, 99305826, 560032817,
				692840724, 392646128, 537483254, 259535376, 535689282, 726712269, 510309308, 183779376, 380111586,
				133375213, 293115120, 537383346, 549735507, 236575386, 606258741, 313398268, 59540093, 657925989,
				530608926, 986241784, 810774706, 460645018, 665838675, 61704685, 402542059, 720381787, 163074762,
				780167307, 318542994, 308967015, 564888479, 90221523, 816398617, 768592518, 198116424, 969169124,
				885364099, 112060124, 27201074, 940332170, 563085950, 748977842, 776117381, 769934445, 921084698,
				207298498, 994001140, 994807522, 446531077, 573829462, 285305886, 375299211, 762222339, 582755138,
				172222548, 960029742, 477706811, 528576148, 872342684, 749187590, 750128758, 796081698, 634451505,
				529429754, 509353637, 514916992, 676465767, 638320400, 627006642, 806374952, 307669258, 675990433,
				716416252, 723786497, 868492001, 567434763, 337423590, 69602135, 991636020, 374340483, 137039270,
				499933836, 829469611, 287013932, 167335350, 855682782, 781692011, 487111196, 537343324, 723403074,
				753113972, 399503840, 96524103, 995262525, 719839182, 997500689, 920399382, 288436848, 986927447,
				257859088, 143327497, 696741938, 746174967, 326715923, 936577531, 460951032, 825961434, 342775670,
				121618013, 670872306, 358906114, 339296878, 80108311, 773547875, 754388127, 909410198, 822929107,
				35334380, 427530075, 414173793, 946444374, 831866396, 970699349, 286023127, 881486715, 411946688,
				576278135, 627547135, 856551982, 250868271, 368556446, 77830494, 751990010, 799749984, 371920637,
				104057865, 916751355, 631938859, 550541362, 558843787, 978531751, 600404394, 443257694, 295754135,
				589533762, 89481994, 494896335, 872432504, 891016229, 883311070, 308399805, 41252412, 924643134,
				878900043, 86838456, 99790904, 504108654, 895208568, 770706527, 628570892, 990410711, 325555359,
				678125170, 276622343, 695869055, 486353996, 100714445, 428699665, 739315887, 2561480, 231164360,
				193880834, 469191680, 565654537, 726434487, 697260557, 680490331, 507859054, 306030895, 628515274,
				527084703, 326410952, 147342793, 121815642, 620385525, 680817495, 204632843, 380760854, 796544163,
				401912713, 445286073, 82134414, 373724327, 752043491, 67051033, 740903670, 837620823, 762508698,
				337359277, 244532007, 298294524, 146110736, 409975388, 592058044, 326528382, 846007253, 497887071,
				481763496, 624821201, 952657654, 220702740, 656746991, 581666451, 674631803, 328635790, 354332058,
				45951869, 637144822, 897696172, 98588647, 731727661, 65168633, 311651200, 724241808, 801418097,
				708822061, 622095751, 870753525, 824337286, 921389153, 539456571, 691442173, 238750275, 660383721,
				128990758, 892645180, 182598722, 647951814, 529538894, 316246193, 272770701, 923390347, 853325524,
				236728461, 965264864, 893388927, 803165321, 80708849, 987342573, 16266343, 858818727, 640364607,
				344618983, 531355524, 520651856, 910343737, 191241621, 690161186, 612270576, 559205978, 630362326,
				261818973, 328525687, 755493886, 72236489, 21978149, 172435866, 404614201, 104269359, 500879373,
				135936674, 254471492, 820394164, 525602904, 472967884, 278130920, 926075587, 761293368, 150291978,
				483513900, 649820419, 605334730, 740230633, 974330410, 470652807, 212311117, 862759578, 443784424,
				622654897, 241296504, 302616992, 50267604, 77207052, 874338270, 356982961, 288875139, 241066232,
				712125311, 951212856, 474495049, 432195160, 934875437, 799203694, 586634735, 52249763, 142329189,
				911048389, 907170580, 49695479, 270614519, 925281122, 464227069, 950479655, 849991860, 266818203,
				362676195, 808560680, 529377131, 508679213, 966842486, 357116770, 823709646, 724966588, 548757103,
				504840583, 614589729, 455573794, 384505744, 907681364, 933407547, 251377926, 680117243, 110785098,
				673088667, 647701163, 943279831, 7396922, 697554166, 470159580, 935955870, 925564488, 277509490,
				216130418, 604205294, 497733748, 423345141, 96981006, 666890523, 966255640, 260328893, 943970462,
				902224602, 945515811, 677536730, 454343311, 491802412, 742873954, 214123664, 59538047, 678850642,
				651351438, 818207198, 316944519, 336772036, 142062156, 198049282, 426514796, 865119410, 311969268,
				8155598, 40753615, 872751209, 187499780, 218116483, 332439911, 659913703, 670966811, 807007162,
				946910765, 982142484, 608284769, 661370190, 914708394, 324610397, 656992296, 532242178, 197208477,
				821135015, 846761509, 525346404, 982739112, 379305072, 738298119, 36430864, 788550295, 452193442,
				715620030, 490630982, 692901989, 994436068, 291970729, 500599919, 641430550, 531467158, 849183538,
				406835198, 931995991, 61943831, 164639280, 517072004, 580794266, 802234653, 311970224, 685668876,
				98637364, 607467687, 405377005, 710497690, 406492834, 496674179, 550106435, 430272419, 733835674,
				555540963, 958128718, 114467261, 79585849, 777084320, 504432845, 927664607, 805457682, 168547695,
				372178003, 542589740, 314981574, 763920546, 644430673, 149424806, 584012241, 397258431, 795431792,
				11127611, 825663950, 930725051, 327022148, 739196798, 908673071, 181811483, 783400502, 83621722,
				350068017, 540171430, 196581901, 928235367, 33260634, 706782083, 917731516, 727185594, 870436115,
				576763387, 454328505, 326011840, 257893320, 994685311, 917989501, 503470778, 970010364, 303103738,
				627810179, 4614969, 977801608, 572083967, 994661860, 547356838, 211164050,

				73555071, 891131938, 985419473, 595124890, 965508126, 826192770, 569919550, 832502135, 210796046,
				170025470, 444884691, 621441484, 373897888, 365421885, 443406104, 630209666, 72936881, 840609256,
				485879174, 175678653, 982556905, 605555219, 350943615, 478986648, 954698848, 970140026, 119088827,
				515374241, 797234448, 307343815, 746398183, 864201961, 51663692, 661512810, 438349973, 312622798,
				248791037, 666214116, 621323059, 507611742, 747251878, 657050668, 216311153, 423911817, 367162549,
				682956912, 614996673, 666971673, 145794240, 314292283, 474598684, 551175793, 698473666, 194903207,
				743375556, 524051776, 701759576, 144836747, 995041669, 119220905, 861401254, 458200028, 356080137,
				6345714, 693205254, 25013207, 522312735, 270166580, 821935276, 639072219, 502010471, 949415780,
				825549869, 374811112, 101262530, 560974503, 35624697, 415306230, 712486684, 922955029, 564145907,
				187261752, 702957833, 598092332, 633214582, 768200365, 838673451, 29104792, 178332242, 351452419,
				444717863, 253717862, 486386115, 201527075, 605555795, 348136231, 10377649, 416358256, 496115481,
				816586270, 477355877, 201638698, 8649775, 136977558, 994097995, 282327336, 19961260, 829891047,
				629366733, 738427345, 378095347, 490191121, 340980763, 586025759, 398259680, 437099239, 407324540,
				365318219, 956024080, 274078590, 837533389, 88914786, 997760079, 799016452, 236210116, 771835675,
				479359629, 51850025, 734242815, 796134425, 594573378, 737655885, 97313950, 352578854, 558442160,
				451570425, 386053103, 47169142, 534265617, 269102481, 536317838, 818920161, 634331733, 644019046,
				887073630, 461453439, 422023623, 578356940, 244178009, 216991742, 140952108, 539780881, 123904768,
				936822771, 277433507, 199818832, 37420318, 955481598, 907324608, 987425707, 742988125, 518341010,
				329263038, 746632519, 24411109, 463715180, 685242739, 877951483, 695067886, 783403551, 272517660,
				221103944, 809680663, 975242576, 212539526, 471393935, 251067396, 409813046, 466468562, 873988848,
				766785330, 414160832, 397119057, 412945261, 34062029, 958930218, 24216291, 997784428, 306839775,
				336582569, 394049025, 908061924, 52285802, 450593335, 908808495, 631048608, 147543230, 161896903,
				106018963, 612144188, 608129840, 818008971, 662652040, 309857741, 576589552, 920550853, 489861261,
				735980219, 761602059, 501729335, 737979209, 22389522, 831216548, 421576134, 980269113, 833394126,
				687250481, 695792895, 693649516, 719008710, 821600286, 954946234, 335398932, 200538440, 984679381,
				341646295, 301734602, 152492676, 789168906, 509504109, 961060878, 125789885, 556466424, 419890854,
				63642591, 99076851, 799673055, 392043268, 81382729, 504681677, 209389494, 754603783, 456600832,
				539035506, 435922926, 210984865, 263548566, 118124767, 166688605, 462937914, 589183416, 362638599,
				159053016, 791461159, 908592584, 313783424, 909068016, 320970927, 458317030, 163159510, 934854666,
				518398042, 848743279, 685480582, 865572433, 199610310, 134679188, 280548208, 783071967, 310507318,
				338854442, 800947073, 932543225, 140898578, 663523673, 660192726, 174111828, 901012978, 205690467,
				579413161, 92443153, 341373951, 467562535, 301011317, 810346114, 409284028, 974435061, 494627664,
				236536716, 408022240, 779648213, 920639717, 476695074, 241071114, 911446595, 922932541, 364236989,
				993168725, 486361231, 272242383, 38518803, 745315214, 791678305, 430294015, 208225361, 336764194,
				137511809, 92654680, 345963415, 350151203, 889869580, 527347785, 25834205, 655847, 124180964, 459291882,
				851401263, 48438636, 240483331, 768016682, 243444660, 154467710, 175577766, 775462576, 20906214,
				71637674, 857623005, 463708985, 691249547, 339533329, 554041986, 131715739, 262006273, 373392018,
				667008685, 199781376, 493108451, 300740534, 219549347, 176629853, 743005911, 279669007, 340615185,
				154675695, 144933157, 506295071, 176147588, 797487717, 664942889, 262906301, 365338297, 97841779,
				734288309, 109549917, 840860408, 746907014, 718057855, 740916330, 491230511, 442717021, 841616870,
				979010715, 906218473, 124147598, 729832116, 392798501, 560784388, 24117498, 244742388, 687858320,
				51229651, 659068987, 391209092, 517400981, 543155251, 311894063, 84946152, 866604375, 300070921,
				730224704, 289518137, 624499560, 597520884, 787189106, 810428094, 500420790, 150505672, 425111285,
				234478561, 38129233, 806913748, 164672847, 951107829, 990393709, 793642046, 17698382, 70403905,
				641167703, 261271222, 860989720, 735013471, 712008056, 480390828, 739830972, 295416572, 499081530,
				740594823, 809245700, 942055107, 433121800, 528154074, 942440902, 64869674, 5534975, 395768912,
				476845427, 851799955, 360799287, 395798498, 968212986, 414175969, 206186304, 120835522, 533644557,
				349712575, 407074246, 509050679, 988005328, 509873933, 238478871, 739698178, 438186598, 163058748,
				375002362, 295111991, 169484958, 13022647, 462060992, 52082541, 238481433, 790563803, 848445648,
				280533327, 785946646, 50615322, 578596830, 798184951, 474911333, 857553007, 694275030, 340567141,
				885490133, 478818269, 260943233, 577975653, 422506234, 407412449, 168653646, 379043154, 122949715,
				209051317, 368791410, 651370688, 693407812, 84064498, 107829907, 198258490, 400570235, 925174147,
				625221666, 152610213, 719858965, 864594107, 977418564, 235990734, 149142645, 656833856, 222809896,
				697414663, 170939581, 772348269, 479384658, 511508658, 962907335, 885899204, 265182594, 316802378,
				330073379, 493494971, 409366962, 586154300, 490604772, 549742774, 146847638, 828030443, 573554043,
				896756399, 533370519, 271817440, 737674670 };

		Integer[] y = new Integer[] { 282542346,282542346, 854081453, 64972279, 218701682, 109428249, 615383624, 873624785,
				26295858, 962925437, 262087850, 739333110, 467578436, 505576807, 423995569, 745548182, 181779059,
				372029957, 603094683, 119762135, 940072403, 35637985, 81964377, 749130750, 106114335, 789515550,
				383736178, 646518439, 744541292, 410284740, 938186794, 47731662, 868285501, 539086880, 60220491,
				215893337, 179966985, 264850750, 496431410, 909428185, 218127540, 820333510, 90980977, 933552266,
				44096488, 296295857, 8507029, 570559467, 923162460, 103369277, 755414052, 753031650, 692059973,
				783520364, 924045162, 15152169, 33249939, 743081574, 784295109, 820213759, 258255411, 620706372,
				902107728, 730272451, 26385221, 68843850, 249724692, 980411732, 994521989, 77553156, 718828477,
				686730718, 918358009, 920750369, 399545018, 68599029, 556582217, 876064774, 8673989, 72905532, 54234676,
				693450726, 127189379, 434754155, 73323548, 36746838, 905428646, 266308210, 323047498, 33649175,
				199399320, 274559677, 54861941, 745240207, 835594861, 768431093, 664482664, 413316141, 955573339,
				393177559, 253548354, 388091859, 361917965, 321704175, 363406356, 23644472, 614276790, 951801718,
				220331697, 970137571, 761103126, 663978146, 688570327, 279154381, 291375613, 657394410, 820960061,
				258748519, 88216372, 108710719, 24426555, 147471878, 491109976, 955718377, 484847251, 414989914,
				387804860, 116320926, 39097555, 325412807, 722307365, 178149510, 169195331, 898940009, 27757181,
				644778650, 719699656, 594161456, 611888924, 447973304, 371585777, 369487488, 452381967, 843751461,
				600579175, 748685649, 372259517, 66708455, 27101195, 579222084, 75795677, 824892710, 696583699,
				236258329, 531705170, 882927560, 484737689, 828798199, 111989348, 15142624, 794398714, 469952616,
				963865789, 457381878, 929696230, 354749352, 52233442, 255010813, 983306929, 313359506, 233881187,
				947395238, 350133211, 896708870, 660203396, 141789147, 358399921, 450905976, 951909383, 965888421,
				189301507, 146029367, 362427412, 531144464, 368236160, 221781412, 426846210, 615610425, 319397114,
				154380103, 265327598, 574639162, 983863729, 867139527, 64184467, 310387225, 396057560, 260808277,
				288080948, 200799727, 383562198, 543367980, 200033284, 632098247, 196711115, 510343902, 196994500,
				222213582, 159752192, 211195868, 23003590, 46354899, 336862097, 638793399, 509736014, 668464784,
				214187500, 647718461, 495630135, 870061242, 842993040, 724408943, 422522560, 773571861, 874467828,
				59333412, 97153582, 30354459, 361325622, 798264029, 472397394, 65291944, 293719292, 54622358, 395064812,
				186977235, 793359672, 139702900, 176247987, 651304233, 875659717, 405386346, 341295504, 663532832,
				538563489, 51577620, 26323321, 341849371, 808806028, 255709334, 102869242, 520657594, 594046429,
				203645229, 240796256, 95881471, 864986584, 361453474, 541609241, 806074672, 502787548, 283689724,
				884615813, 3881260, 738105192, 194542227, 376877614, 226655960, 652075369, 836029378, 239310728,
				806449759, 811428020, 507335531, 30978461, 878637609, 342998923, 334406825, 244808213, 393156020,
				105076067, 242174606, 61360821, 631675029, 633816583, 453834687, 158141177, 547013416, 386565178,
				610914362, 795097696, 32522537, 626546918, 587296153, 132961109, 283711924, 119019335, 485383824,
				420056692, 620768415, 227863501, 373963263, 729291275, 623367271, 295664243, 547303934, 580314849,
				737121310, 190722407, 239097198, 271402174, 643497420, 514089480, 299216720, 760235940, 630974196,
				499010791, 906195420, 455641158, 881907089, 546112669, 109160570, 323583891, 54617017, 380622337,
				401522551, 19698245, 288624379, 885582154, 644041340, 464676154, 357337059, 12226193, 518827907,
				484210648, 985691359, 411885396, 927898649, 171058048, 527671121, 824992145, 581628710, 883945822,
				983405663, 896601512, 884448765, 591567140, 287818571, 35297802, 509058556, 532358323, 365583814,
				965757188, 543211220, 746206573, 649534612, 275358210, 672626208, 374142561, 112689406, 291779320,
				536026674, 874958201, 656701860, 691323894, 903283026, 65925386, 790650239, 782399466, 587575629,
				143522484, 726973978, 933616081, 975172361, 438252736, 364802485, 443870501, 843818524, 429683688,
				63297650, 124497787, 940414336, 63040906, 832136883, 705917066, 300251118, 446196489, 861946312,
				8647269, 263160357, 259896336, 147314911, 737246872, 941876969, 505313892, 160743531, 186098628,
				852462253, 819237125, 590385056, 144024116, 720623285, 169069646, 920172849, 919986352, 903657973,
				560794960, 621712814, 70845364, 82255519, 724019947, 677027160, 217014623, 752053442, 533109580,
				503948524, 905416205, 632988496, 71915046, 207476636, 953686500, 907465884, 783268894, 425059322,
				475481271, 975138699, 814453524, 341375939, 696454348, 543090679, 224627465, 882290257, 902351539,
				170570615, 426395614, 940499054, 174958097, 240901554, 203009674, 498507847, 105237270, 726434877,
				928109869, 922719535, 347319443, 868965669, 593174339, 932346199, 163451625, 396814599, 323254679,
				803455651, 884193413, 874208891, 95242907, 514910852, 112575225, 992633390, 132691879, 959824922,
				384299683, 271572816, 774416603, 622239319, 412595799, 673590147, 582702336, 564083119, 960306399,
				668765993, 951324194, 132863515, 824372562, 4477569, 660800832, 944974995, 75851642, 187916377,
				328903753, 701772321, 799997821, 794171520, 266558015, 107658522, 992905907, 896137382, 793878846,
				149100893, 801061909, 167285681, 529168234, 46156340, 535389040, 280551023, 517386676, 177517620,
				180705621, 713598873, 616839802, 52063406, 341330397, 381718783, 340009632, 123554243, 947803778,
				831683187, 883705337, 247263747, 156622571, 153677711, 182165302, 917553583, 856171521, 436180722,
				795885638, 989856909, 935879515, 510008124, 631757763, 886557094, 648179354, 741579719, 806251197,
				438488024, 427217951, 774424867, 561379717, 315353692, 166932848, 428419492, 140195926, 213614489,
				981376527, 647100213, 826256297, 811551873, 222681547, 850520948, 195632819, 152664573, 557547836,
				247959147, 909312024, 893182618, 169723975, 740296108, 306290638, 470501314, 414491825, 12251965,
				336255479, 402443593, 281286090, 940071958, 968014030, 238379222, 708819706, 610646378, 994477967,
				558344811, 293609111, 328448403, 682134452, 4997775, 416389678, 23568805, 470962985, 619575779,
				84869969, 821398246, 290926459, 744860180, 895412828, 179738470, 256809680, 591154539, 290478253,
				282119413, 243154161, 437485622, 353334920, 625745182, 159241544, 705036801, 583581560, 83033319,
				831227261, 540414861, 18878170, 598550111, 30529509, 455771661, 400300953, 298811648, 591672677,
				925383435, 201340975, 777891609, 293663294, 452431252, 883551731, 943285171, 18321407, 790536605,
				642559051, 474307512, 441886013, 113531972, 147574789, 837572320, 782264031, 760347431, 95739213,
				23383834, 572457559, 674315723, 376553442, 261697377, 602167216, 67986072, 729620679, 786067077,
				8943072, 680250615, 427478785, 708198452, 544385113, 133524092, 977018164, 120384076, 751140653,
				65604585, 931252904, 624576728, 372665227, 245636579, 772586445, 825650656, 142060560, 214748422,
				888774395, 633934773, 636117446, 104892898, 863960491, 958952249, 230155003, 786133824, 78678727,
				877964039, 312213796, 31679158, 341276299, 501103074, 864322827, 274084258, 109513673, 107627303,
				542473752, 771158724, 963334450, 147709518, 127598982, 959291909, 667082476, 568103589, 207428638,
				994807607, 380366583, 554504710, 262122974, 123916985, 912666841, 241368983, 143295990, 370966219,
				722501112, 345764388, 397418684, 658931944, 861406022, 934039430, 318391997, 807347760, 535549741,
				441205894, 688705172, 603900796, 161002410, 556713166, 594042559, 68172115, 76233040, 48271369,
				184116104, 92474511, 714654950, 465378866, 95326394, 31804437, 647058264, 356705333, 239053386,
				581544441, 589819912, 69711583, 515891269, 453283547, 3810613, 759186332, 370645997, 26743549,
				742278047, 183728659, 411526744, 695474433, 641429975, 431844650, 141957932, 4008253, 254850445,
				994623486, 907002732, 250772983, 461812032, 782888105, 366203292, 314806158, 313425795, 792525730,
				98428988, 54455157, 428398752, 585681535, 451441489, 793327984, 69836145, 141680330, 774318641,
				416646138, 484358736, 474001596, 838991684, 973471843, 518308611, 278033825, 350342340, 486382294,
				58923327, 908855892, 82147168, 645158718, 555422397, 262724011, 536753712, 858424772, 803428620,
				286142314, 833992654, 402750245, 340449386, 841024234, 949028116, 177954316, 527918002, 490090427,
				462143228, 788166862, 657457762, 514117996, 498384917, 468947804, 253660389, 91210597, 161519971,
				74724320, 319142700, 826071289, 395842168, 624336843, 483543231, 637456314, 971577618, 49389031,
				440914749, 174990555, 739591597, 635617464, 323717273, 410128284, 155892522, 394494479, 267366947,
				217290260, 81080770, 432227752, 184318422, 733693789, 861823653, 357139170, 577480550, 470634169,
				216805512, 273346713, 27790357, 238606565, 689961156, 65807229, 344478228, 4765827, 831667030,
				846902058, 124876389, 68504660, 220746306, 32889270, 271504497, 152938378, 34927494, 613044952,
				321881569, 428032543, 824011471, 958079564, 912073329, 655456921, 858205718, 228012434, 562340755,
				470894087, 946071631, 148123139, 646005380, 56396462, 890728389, 253374706, 907733087, 991178056,
				48138029, 90153004, 946180169, 807410085, 568835342, 523076086, 178750930, 641914284, 210297914,
				647835212, 113009018, 415587843, 182637257, 53882294, 621836749, 902297857, 758311362, 228407013,
				768864655, 351029187, 640584075, 712705019, 366930254, 226777150, 871955820, 443252955, 432084336,
				747346338, 490225193, 321700476, 588738616, 819905066, 951698154, 365223741, 369821234, 125953562,
				336680495, 958476151, 980124249, 909577962, 964301806, 545479753, 8536799, 426940518, 926559324,
				649189873, 383275600, 114474720, 726260636, 970531340, 369087185, 60591629, 545514113, 933529903,
				531583301, 596346173, 854560950, 460399357, 436340708, 672844477, 410537411, 747191325, 506576238,
				609008660, 158119349, 531376561, 109337077, 564883362, 767515319, 172136403, 382589876, 157547253,
				333914120, 478059329, 149022875, 435711164, 953962476, 407553264, 865011890, 83797347, 73597533,
				934437644, 383026062, 138465137, 109112769, 968762092, 211483644, 697768665, 757485856, 79514605,
				750103791, 76574928, 959432131, 614234893, 737765476, 825899167, 702663707, 581621307, 310585463,
				502038113, 430425895, 473034138, 950986475, 812510800, 125680721, 485129653, 661145124, 278651695,
				843429060, 519048196, 890154927, 981551255, 979118147, 943289466, 960983502, 248981660, 564716531,
				544481580, 843776173, 36194303, 989721782, 113881927, 533435797, 920435217, 545497112, 23123230,
				984793379, 74651443, 74060397, 901980006, 78022421, 798936525, 209777253, 994675869, 23924959, 58119400,
				204451546, 916830328, 143091991, 533000427, 248335138, 258040426, 27471134, 128995702, 46748560,
				685833712, 406760179, 993862586, 233954456, 33570249, 716211728, 592257191, 703976453, 898417577,
				221829256, 630171256, 64359206, 17700337, 282238600, 208267116, 977922481, 12479703, 439769081 };
		Integer[] vol = new Integer[] { 1,89, 450, 983, 843, 149, 871, 736, 408, 860, 922, 619, 956, 200, 69, 629, 325,
				104, 690, 266, 485, 902, 509, 850, 713, 496, 901, 535, 856, 100, 196, 573, 24, 655, 717, 555, 867, 533,
				769, 823, 980, 715, 818, 239, 89, 838, 740, 880, 463, 698, 476, 325, 527, 796, 49, 160, 211, 885, 999,
				912, 593, 416, 393, 842, 159, 520, 198, 899, 291, 974, 187, 591, 484, 501, 189, 406, 416, 120, 751, 44,
				314, 397, 614, 18, 210, 64, 594, 71, 431, 343, 616, 828, 93, 558, 132, 333, 778, 173, 201, 113, 587,
				861, 82, 892, 370, 511, 143, 89, 49, 275, 474, 912, 840, 898, 471, 286, 21, 126, 49, 420, 893, 14, 623,
				860, 392, 582, 839, 987, 280, 729, 787, 432, 713, 361, 294, 444, 730, 335, 768, 438, 429, 693, 932, 561,
				847, 593, 764, 532, 225, 567, 278, 659, 340, 329, 848, 153, 936, 611, 953, 931, 484, 261, 574, 999, 485,
				270, 541, 969, 423, 789, 579, 933, 724, 782, 488, 709, 801, 152, 136, 808, 192, 705, 242, 267, 271, 756,
				867, 831, 550, 364, 692, 240, 197, 57, 683, 727, 140, 803, 478, 647, 759, 600, 457, 442, 351, 652, 732,
				956, 948, 900, 866, 545, 71, 342, 293, 309, 365, 728, 736, 196, 673, 939, 58, 799, 922, 988, 505, 458,
				799, 928, 89, 950, 944, 193, 13, 3, 968, 163, 259, 777, 125, 936, 285, 602, 184, 105, 484, 351, 486,
				730, 233, 587, 477, 324, 215, 509, 483, 344, 992, 347, 736, 86, 235, 845, 812, 677, 176, 602, 360, 288,
				372, 308, 379, 163, 981, 96, 84, 948, 613, 227, 589, 537, 512, 131, 957, 724, 584, 896, 910, 665, 208,
				809, 26, 859, 720, 610, 543, 565, 252, 985, 528, 578, 86, 307, 676, 613, 438, 100, 996, 714, 438, 198,
				902, 508, 557, 2, 860, 345, 719, 101, 841, 454, 261, 151, 775, 348, 879, 570, 526, 90, 780, 916, 145,
				176, 994, 408, 620, 454, 503, 301, 429, 764, 649, 928, 540, 264, 675, 171, 283, 251, 736, 244, 635, 952,
				973, 343, 780, 432, 314, 118, 903, 558, 506, 180, 334, 117, 872, 928, 153, 51, 682, 29, 612, 45, 424,
				313, 261, 646, 421, 255, 702, 859, 841, 639, 491, 275, 947, 742, 873, 856, 988, 479, 342, 178, 319, 190,
				682, 188, 588, 207, 578, 669, 681, 657, 272, 421, 97, 765, 652, 521, 184, 639, 485, 120, 16, 995, 423,
				590, 252, 318, 657, 618, 955, 717, 51, 185, 992, 497, 862, 210, 583, 494, 412, 472, 668, 912, 680, 492,
				342, 23, 269, 903, 164, 389, 464, 583, 808, 467, 112, 292, 14, 150, 207, 685, 598, 783, 463, 384, 787,
				659, 106, 745, 519, 231, 381, 980, 202, 365, 252, 789, 46, 819, 371, 219, 363, 785, 338, 473, 448, 772,
				211, 838, 930, 354, 457, 473, 283, 32, 748, 743, 284, 161, 658, 835, 120, 187, 839, 550, 874, 206, 957,
				304, 671, 291, 300, 497, 927, 193, 946, 324, 786, 770, 456, 587, 961, 368, 834, 587, 84, 699, 933, 272,
				838, 825, 466, 368, 605, 108, 261, 989, 615, 805, 443, 948, 165, 896, 232, 366, 98, 313, 660, 820, 654,
				678, 257, 732, 328, 759, 721, 876, 768, 393, 388, 973, 340, 783, 7, 760, 416, 144, 294, 226, 701, 411,
				806, 682, 627, 522, 386, 287, 773, 918, 92, 677, 956, 499, 926, 8, 117, 423, 966, 414, 566, 298, 928,
				92, 838, 409, 837, 212, 852, 222, 927, 338, 756, 36, 650, 92, 511, 966, 73, 797, 880, 994, 741, 329,
				854, 412, 647, 407, 885, 328, 826, 418, 826, 536, 312, 719, 343, 716, 44, 518, 536, 657, 309, 316, 184,
				99, 426, 441, 134, 858, 573, 373, 311, 755, 694, 942, 971, 688, 364, 181, 504, 494, 185, 469, 648, 199,
				229, 769, 473, 469, 739, 137, 127, 217, 169, 424, 251, 888, 424, 251, 538, 612, 416, 523, 745, 142, 581,
				28, 893, 434, 853, 768, 617, 613, 927, 955, 209, 449, 555, 44, 712, 43, 778, 978, 39, 426, 565, 339,
				528, 851, 80, 773, 225, 285, 150, 432, 737, 112, 681, 242, 809, 217, 293, 666, 565, 726, 181, 49, 78,
				805, 996, 193, 236, 115, 5, 742, 336, 676, 556, 664, 829, 52, 398, 782, 876, 34, 223, 857, 355, 385,
				674, 110, 823, 532, 889, 938, 811, 937, 217, 524, 222, 223, 352, 828, 761, 947, 4, 59, 263, 44, 969,
				735, 787, 682, 68, 606, 541, 757, 630, 667, 90, 668, 786, 651, 888, 994, 684, 965, 467, 260, 278, 986,
				981, 502, 786, 971, 187, 121, 300, 900, 1, 684, 329, 383, 457, 943, 851, 312, 859, 179, 987, 391, 875,
				746, 972, 437, 597, 858, 7, 371, 725, 739, 76, 325, 69, 18, 100, 761, 74, 757, 155, 16, 513, 436, 980,
				625, 396, 441, 951, 587, 451, 114, 758, 978, 538, 916, 468, 341, 61, 255, 858, 609, 870, 672, 52, 992,
				2, 874, 289, 171, 71, 550, 174, 70, 685, 879, 46, 148, 194, 560, 792, 597, 720, 663, 143, 673, 688, 510,
				330, 165, 965, 662, 154, 266, 632, 973, 522, 573, 294, 589, 802, 699, 115, 236, 219, 98, 405, 511, 471,
				673, 319, 225, 641, 354, 122, 771, 210, 865, 271, 706, 745, 924, 557, 243, 485, 976, 90, 36, 472, 841,
				588, 711, 738, 337, 211, 633, 776, 487, 947, 330, 729, 580, 348, 734, 988, 703, 825, 657, 926, 79, 263,
				510, 803, 634, 939, 858, 530, 382, 115, 922, 177, 121, 435, 652, 960, 38, 705, 815, 58, 855, 293, 124,
				598, 611, 225, 535, 458, 151, 962, 727, 489, 613, 749, 328, 692, 374, 637, 788, 399, 562, 513, 634, 940,
				510, 642, 475, 919, 909, 978, 932, 744, 860, 47, 93, 841, 880, 866, 851, 858, 107, 539, 886, 509, 933,
				142, 311, 153, 612, 959, 654, 848, 684, 568, 917, 951, 993, 350, 948, 224 }; // 51+25
		List<Integer> x1 = Arrays.asList(x);
		List<Integer> y1 = Arrays.asList(y);
		List<Integer> z1 = Arrays.asList(vol);

		System.out.println(x1.size());
		for (int i : x1)
			System.out.println(i);
		System.out.println(y1.size());
		for (int i : y1)
			System.out.println(i);
		 System.out.println(z1.size());
		for (int i : z1)
			System.out.println(i);
//		System.out.println("---------");
		// System.out.println(phoneCalls(x1, y1, z1));
		// 15706

		// 27
		// 25 2118 1710

		// 10 1922 1514

	}

	static int maximum = 0;

	public static int phoneCalls(List<Integer> start, List<Integer> duration, List<Integer> volume) {
		int count = 0;
		Order[] or = new Order[start.size()];
		for (int i = 0; i < start.size(); i++) {
			or[i] = new Order();
			or[i].arri = start.get(i);
			or[i].depart = or[i].arri + duration.get(i);
			or[i].weight = volume.get(i);

		}

		Comparator<Order> comp = new Comparator<Order>() {

			@Override
			public int compare(Order o1, Order o2) {
				// TODO Auto-generated method stub
				if (o1.arri == o2.arri) {
					return o1.depart - o2.depart;
				}
				return o1.arri - o2.arri;
			}
		};

		Arrays.sort(or, comp);

		for (int i = 0; i < or.length; i++)
			System.out.println(or[i]);
		int maximum = 0;
		int n;
		for (int i = 0; i < or.length; i++) {
			n = next(or, or[i].depart, i);
			if (n != -1)
				or[i].maxVal = maxItems(or, or[i].weight, n, or[n]);
			if (maximum < or[i].maxVal)
				maximum = or[i].maxVal;
		}
		System.out.println("-------------");
		System.out.println(maximum);
		for (int i = 0; i < or.length; i++) {
			Integer first = or[i].arri;
			or[i].tempVal = or[i].weight;
			int max = or[i].weight;
			n = next(or, or[i].depart, i);

			System.out.println("----------");
			System.out.println(or[i]);
			while (n != -1) {
				if (n < or.length - 1 && or[n].arri == or[n + 1].arri) {
					max = maxItem(or, max, n);
					break;
				}
				or[n].maxVal = max;
				max += or[n].weight;
				System.out.println(or[n]);
				n = next(or, or[n].depart, i);

			}

			if (maximum < max) {
				maximum = max;
			}
			System.out.println(max);

		}

		return maximum;

	}

	static int maxItems(Order[] order, int maxs, int index, Order os) {
		int max = maxs;
		Queue<Order> queue = new LinkedList<Order>();

		for (int i = index; i < order.length; i++) {
			order[i].maxVal = maxs;
			queue.add(order[i]);
		}
		int maxe = 0;
		while (!queue.isEmpty()) {
			Order or = queue.poll();
			or.maxVal += or.weight;
			System.out.println(or);
			int n = next(order, or.depart, index);
			if (n != -1) {
				or.maxVal = maxItems(order, or.maxVal, n, or);
			}

			if (maxe < or.maxVal)
				maxe = or.maxVal;
			or.maxVal = 0;

		}
		return maxe;
	}

	static int maxItem(Order[] order, int maxs, int index) {
		int max = maxs;
		Stack<Order> st = new Stack<>();
		int temp = index;
		st.push(order[temp]);
		while (temp < order.length - 1 && order[temp].arri == order[temp + 1].arri) {
			st.push(order[temp + 1]);

			temp++;
		}
		int i = index;
		while (!st.isEmpty()) {
			Order or = st.pop();
			max += or.weight;
			int n = next(order, or.depart, i);

			while (n != -1) {
				if (n < order.length - 1 && order[n].arri == order[n + 1].arri) {
					max = maxItem(order, max, n);
					break;
				}
				order[n].maxVal = max;
				max += order[n].weight;
				n = next(order, order[n].depart, i);

			}
			i++;
			if (maximum < max) {
				maximum = max;
			}
		}

		return max;
	}

	static int next(Order[] order, Integer target, int index) {
		int start = index;
		int last = order.length - 1;
		int ans = -1;
		while (start <= last) {
			int mid = (start + last) / 2;
			if (order[mid].arri <= target) {
				start = mid + 1;

			} else {
				ans = mid;
				last = mid - 1;
			}
		}

		if (ans != -1 && index > 1 && order[ans - 1] == order[ans]) {
			while (ans > 1 && order[ans - 1] == order[ans]) {
				ans--;
			}
		}
		return ans;

	}

	static class Order {
		Integer arri;
		Integer depart;
		Integer weight;
		Integer maxVal;
		Integer tempVal;

		@Override
		public String toString() {
			return "Order [arri=" + arri + ", depart=" + depart + ", maxval=" + maxVal + ", weight=" + weight + "]";
		}

	}
}