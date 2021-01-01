-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 01, 2021 at 04:55 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id15810877_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `adview_data`
--

CREATE TABLE `adview_data` (
  `adview_id` int(200) NOT NULL,
  `link` varchar(200) NOT NULL,
  `image` varchar(1000) NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adview_data`
--

INSERT INTO `adview_data` (`adview_id`, `link`, `image`, `added_date`) VALUES
(1, 'helo3', 'http://i.ibb.co/6BLycsW/1.jpg', '2020-02-22 11:39:38');

-- --------------------------------------------------------

--
-- Table structure for table `app_post`
--

CREATE TABLE `app_post` (
  `post_id` int(10) NOT NULL,
  `post_detail` varchar(2550) NOT NULL,
  `post_image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `app_post`
--

INSERT INTO `app_post` (`post_id`, `post_detail`, `post_image`) VALUES
(1, '<p>dsfsfsdf</p>\r\n', ''),
(2, '<p>dsfsfsdf</p>\r\n\r\n<figure class=\"easyimage easyimage-full\"><img alt=\"\" src=\"blob:http://localhost/02338cc0-2331-4e24-ac2f-4edc4eb13777\" width=\"1280\" />\r\n<figcaption></figcaption>\r\n</figure>\r\n\r\n<p>&nbsp;</p>\r\n', ''),
(3, '<p>sdvzdvcxvxvxcv&nbsp;</p>\r\n\r\n<figure class=\"easyimage easyimage-full\"><img alt=\"\" src=\"blob:http://localhost/833eb774-0d8c-4637-9e99-1bb076d35b65\" width=\"1280\" />\r\n<figcaption></figcaption>\r\n</figure>\r\n\r\n<p>&nbsp;</p>\r\n', ''),
(4, '<p>YouTube is an American online video-sharing platform headquartered in San Bruno, California. Three former PayPal employees&mdash;Chad Hurley, Steve Chen, and Jawed Karim&mdash;created the service in February 2005. Google bought the site in November 2006 for US$1.65 billion; YouTube now operates as one of Google&#39;s subsidiaries.&nbsp;<a href=\"https://en.wikipedia.org/wiki/YouTube\">Wikipedia</a></p>\r\n\r\n<figure class=\"easyimage easyimage-full\"><img alt=\"\" src=\"blob:http://localhost/dafb34a6-d669-4c1d-b7c0-a6038782112b\" width=\"1920\" />\r\n<figcaption></figcaption>\r\n</figure>\r\n\r\n<p>&nbsp;</p>\r\n', ''),
(5, '<p>ggggggggggggggggggggggggggggg</p>\r\n\r\n<figure class=\"easyimage easyimage-full\"><img alt=\"\" src=\"blob:http://localhost/77ca7741-2afa-42c0-b12f-b352103bed74\" width=\"1280\" />\r\n<figcaption></figcaption>\r\n</figure>\r\n\r\n<p>&nbsp;</p>\r\n', ''),
(6, '<p>sssssssssssssss</p>\r\n\r\n<figure class=\"easyimage easyimage-full\"><img alt=\"\" src=\"blob:http://localhost/d402f8a6-edbc-4830-88c0-ec2e57daef25\" width=\"1280\" />\r\n<figcaption></figcaption>\r\n</figure>\r\n\r\n<p>&nbsp;</p>\r\n', '');

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `memberID` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `active` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `resetToken` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `resetComplete` varchar(3) COLLATE utf8mb4_bin DEFAULT 'No'
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`memberID`, `username`, `password`, `email`, `active`, `resetToken`, `resetComplete`) VALUES
(1, 'user', '$2y$10$JnDXsl9sBvEGXEJHgh2ah.PJzJjqyKme6wI9J9nsphMyNtE2OsYp6', 'vzv00886@eoopy.com', '8c47c3e5c29b9179d0522a4bb2a470e7', NULL, 'No'),
(2, 'admin', '$2y$10$DF9G39FiUtCgSjX1OMIYIOwVKQSydcaut4yzIkVBvISu7zHG55WIy', '00', '827e84bc369c14106c2f3928a5975ff6', NULL, 'No'),
(3, 'aaa', '$2y$10$TsZpznasIbY7Ub17tgHjH.PokTg9DoGZSIDDJ0kpDRPNLuijwhgxS', 'dineshchavan2510@gmail.com', 'Yes', '1b9c21024c70aac68e5089b555f2a12f', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `pc_blog`
--

CREATE TABLE `pc_blog` (
  `blog_id` int(10) NOT NULL,
  `blog_title` varchar(2550) NOT NULL,
  `blog_content` varchar(1000) NOT NULL,
  `user_id` int(255) NOT NULL DEFAULT 0,
  `blog_image` varchar(2000) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `disable_flag` int(20) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pc_blog`
--

INSERT INTO `pc_blog` (`blog_id`, `blog_title`, `blog_content`, `user_id`, `blog_image`, `created_at`, `disable_flag`) VALUES
(1, 'Did even but nor are most gave hope depend son repair day ladies now', 'Lorem Ipsums is simply dummy text of the print industry. Lorem Ipsum has industry\'s standard dummy text ever since. Lorem Ipsums is simply dummy text of the print industry. Lorem Ipsum has industry\'s standard dummy text ever since.\r\n\r\nProin vitae blandit felis. Proin rhoncus imperdiet facilisis. Etiam et mauris ex. Maecenas posuere ipsum orci, at imperdiet est venenatis quis. Maecenas quis fermentum ipsum, ac eleifend urna. Cras sed viverra nibh. Mauris eget finibus erat. Mauris tempor varius purus nec cursus. Nullam ornare eget ipsum sit amet consequat. Nunc finibus vitae diam non suscipit. Praesent elementum felis sit amet urna tempus commodo. Proin congue id ante ac maximus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec euismod arcu venenatis, viverra arcu eu, efficitur mauris. Aliquam sagittis sagittis elit, in cursus est faucibus in.', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(2, 'Google\r\nTechnology company', 'Google LLC is an American multinational technology company that specializes in Internet-related services and products, which include online advertising technologies, a search engine, cloud computing, software, and hardware. Wikipedia', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(3, 'Google\r\nTechnology company', 'Google LLC is an American multinational technology company that specializes in Internet-related services and products, which include online advertising technologies, a search engine, cloud computing, software, and hardware. Wikipedia', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(4, 'Make A Tea', '<h2><strong>Lorem Ipsums is simply dummy text of the print industry. Lorem Ipsum has industry&#39;s standard dummy text ever since. Lorem Ipsums is simply dummy text of the print industry. Lorem Ipsum has industry&#39;s standard dummy text ever since. Proin vitae blandit felis. Proin rhoncus imperdiet facilisis. Etiam et mauris ex. Maecenas posuere ipsum orci, at imperdiet est venenatis quis. Maecenas quis fermentum ipsum, ac eleifend urna. Cras sed viverra nibh. Mauris eget finibus erat. Mauris tempor varius purus nec cursus. Nullam ornare eget ipsum sit amet consequat.</strong> Nunc finibus vitae diam non suscipit. Praesent elementum felis sit amet urna tempus commodo. Proin congue id ante ac maximus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec euismod arcu venenatis, viverra arcu eu, efficitur mauris. Aliquam sagittis sagittis elit, in cursus est faucibus in.</h2>\r\n\r\n<blockquote><em>Nunc blandit tincidunt consequat. Duis diam metus, suscipit ininar eget, eges', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(5, 'oooo', '<ol>\r\n	<li><em><strong>hello bhai hwo are toy</strong></em>\r\n	<figure class=\"easyimage easyimage-full\"><img alt=\"\" src=\"blob:http://localhost/blog/admin/blog_img/5902b821-a43a-4a04-b4ae-16d37643cec3\" width=\"100\" />\r\n	<figcaption></figcaption>\r\n	</figure>\r\n\r\n	<p>&nbsp;</p>\r\n	</li>\r\n</ol>\r\n', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(6, 'Apple', 'Apple or Apple Inc. was established in 1976 by Steve Jobs with its headquarters situated in Cupertino, California, USA. Apple is amongst the best rated brands in the world present in over more than 90 countries. This company has gained wide recognition and popularity amongst the customers for more than four decades now.\r\n\r\nApple, in India, is the most popular for its hardware consumer products. Apple sells personal computers in the name of Macbook and attracts the consumers for its smooth functionality. The main trademarks of an Apple computer are its wide ranged features, amazing performance, in built technology and elegance.\r\n\r\nFollowing are some of the Apple computers/laptop variants available:\r\n\r\nApple Mac Pro\r\nApple Mac Mini\r\nApple MacBook Air\r\nApple MacBook Pro\r\nApple iMac\r\nApple iMac Pro', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(7, 'Hewlett-Packard(HP)', 'Hewlett- Packard(HP) is a multinational IT company located in California ,USA. Established in the year 1939, HP boasts of having the highest numbers of costumers buying laptops in India. HP has a market base in over more than 150 countries with the biggest market in India.\r\n\r\nHaving a good reputation of over many decades of service, HP holds a name in the market of making laptops with the latest technology and offers great features with excellent performance. Its amazing inbuilt technology has given the company the mileage to be on the top in the market. The HP Pavilion Notebook is considered the best selling laptop variant of this brand.\r\n\r\nSome of the widely popular HP variants are:\r\n\r\nHP Pavilion dv2z\r\nHP Pavilion dv7\r\nHP Pavilion dv9700t\r\nHP Pavilion TX1000\r\nHP Pavilion x360\r\nHP 520 Notebook\r\nHP Envy', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(8, 'Dell', 'Dell is a US Multinational company with its headquarters located in Round Rock, Texas. This company was founded in the year 1984 and is now operational in more than 70 countries around the world. This three decade old company is popular due to the smooth in built features in their laptops.\r\n\r\nThe company boasts of manufacturing laptops which are unique in their styles, performance, and elegance and thus have gained a wide recognition and a name for itself in the market. The most heavily sold laptop of Dell is the Dell Inspiron in the Indian market and has a good reputation in the market base.\r\n\r\nSome of the major Dell variant laptops are:\r\n\r\nDell Inspiron\r\nDell Vostro\r\nDell Ultrabook\r\nDell XPS', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(9, 'VAIO', 'Vaio was established in the year 1996. This company was a subsidiary to Sony till Feb 2014 but Sony sold 95% stake ownership right of the company to Japanese company namely Japan Industrial Partners in 2014.\r\n\r\nThe main trademark of the company is the manufacturing of the laptops with excellent performance skills. The laptops are good in their in built features, elegance, durability and strength. This company has a big market in India with increase in sale every year.\r\n\r\nSome of the laptops sold by them are:\r\n\r\nVaio Flip Series\r\nVaio Ultra Book p13/11\r\nVaio Sonic F15\r\nVaio F15A/14A\r\nVaio F14', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(10, 'LENOVO', 'Lenovo is a very popular Chinese company established in the year 1984. It has a wide market base serving to customers in more than 60 countries around the world. This company has garnered a name of itself in manufacturing and selling of laptops with an excellent performance skills. The laptops produced from these companies have well in built features, elegance, durability and strength.\r\n\r\nOne unique character of Lenovo laptops are their lifelike gaming experience. The Y series of Lenovo Laptops are specially designed for gamers and are a gamer’s paradise due to its larger than life gaming experience. They are widely popular in the Indian market and helps in generating a lot of revenue due to its high reputed market value.\r\n\r\nSome of the variants of the Lenovo Laptops are:\r\n\r\nLenovo Y Series\r\nLenovo V Series\r\nLenovo S Series\r\nLenovo Flex Series\r\nLenovo Yoga Series\r\nLenovo G Series\r\nLenovo ThinkPad Edge Series\r\nLenovo ThinkPad W Series', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(11, 'SAMSUNG', 'Samsung is a South Korean Company established in the year 1969. Though it was established five decades ago, but they started manufacturing electronic products since 1988. Its headquarters being situated in in Suwon, south Korea, Samsung is rated amongst one of the top most biggest companies manufacturing electronic goods on a global platform.\r\n\r\nThough its trademark has always been in manufacturing smartphones, but in the past few years Samsung has earned a good name in laptop segment too. The smooth functionality with amazing performance skills topped with durability and elegance has made the Samsung laptops consumer friendly and has earned a good reputation in the market.\r\n\r\nSome of the widely sold Samsung laptops are:\r\n\r\nSamsung Galaxy Note Series\r\nSamsung Galaxy Note8.0\r\nSamsung Galaxy Note Pro\r\nSamsung Galaxy Note 10.1\r\nSamsung NC 10\r\nSamsung N130', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(12, 'asus', 'Asus was established in the year 1989 with its headquarters at Taipei, Taiwan. This company has garnered a good name of itself on a world market in a very less time span. Asus boasts of manufacturing high class laptops with top performance skills, wide ranged features, technology and strength at a very less price.\r\n\r\nThis company has earned a good reputation in manufacturing of electronic goods in a world market in a less time.\r\n\r\nSome of the laptop variants of Asus Company are:\r\n\r\nAsus VivoBook S200E\r\nAsus ROG G750JX\r\nAsus X551CA\r\nAsus N55L', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(13, 'acer', 'Acer was established in the year 1976 with its headquarters in New Taipei, Taiwan. Though it was established in 1976, but it came to India in 1990s. This company has achieved new mileage in the world market scenario due to its competitive nature.\r\n\r\nAcer boasts of manufacturing laptops with long battery backup, excellent digital quality of sound and its sleek designs of screen display. It also manufactures laptops with good performance skills, wide features, elegance and strength. Now, in India Acer laptops is in high demand which has uplifted the company’s worldwide value.\r\n\r\nSome of the Acer laptops are:\r\n\r\nAcer Aspire E\r\nAcer Aspire Chromebook\r\nAcer Aspire S\r\nAcer Aspire R', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(14, 'Toshiba', 'Toshiba is a Japanese company with his headquarters located in Minato, Tokyo, Japan. Since its inception in the year 1939, Toshiba has earned a lot of applause and accolades for manufacturing consumer friendly electronic appliances at affordable rates.\r\n\r\nToshiba boasts of manufacturing laptops with good battery backup, excellent performance, amazing features, better technology and durability. This company of more than seven decades fame has a good market base in India and simultaneously on global platforms.\r\n\r\nSome of the widely sold Toshiba laptops are:\r\n\r\nToshiba Satellite\r\nToshiba Tecra\r\nToshiba Satellite UHD 4K\r\nToshiba Portege\r\nToshiba Satellite Pro\r\n', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(15, 'ALIENWARE', 'Alienware is a subsidiary product of Dell. This laptop brand basically deals with gaming and its experiences. This is the most sought after laptop brand for gamers. The Alienware boasts of providing best hardware, high class gaming features and advanced technology combined in one but at a high price.\r\n\r\nThis combination is well received by the gamers or the costumers looking for gaming experience and it caters to the expectations of the customers by providing lifelike gaming experience. Alienware has achieved a good reputation in the marketplace in India as well as across the globe due to its hands on gaming experience.', 0, 'https://i.imgur.com/ZCTEBj4.jpg', '2020-05-05 08:36:18', 0),
(16, '', '<p>yfbjfbdfgsdnfjsjdgfiuhsdfjsndfiusdfsd</p>\r\n', 0, '', '2020-07-27 13:15:19', 0),
(17, '', '<p>yfbjfbdfgsdnfjsjdgfiuhsdfjsndfiusdfsd</p>\r\n', 0, '', '2020-07-27 13:17:28', 0),
(18, 'hbsjkcad', '<p>djsdkcnskjdcnsdlhiusd isuhosdcysdbhskdncsduhcscs</p>\r\n', 0, 'blog_images/icons8-one-free-96.png', '2020-07-27 13:23:06', 0),
(19, 'vs.dkvjhsdsdhsdvksh', '<p><a href=\"javascript:top.window.close()\"><img src=\"https://www.pixeldev.in:2083/cpsess0483882715/frontend/paper_lantern/filemanager/close.jpg\" /></a></p>\r\n\r\n<h1><img alt=\"application/x-httpd-php\" src=\"https://www.pixeldev.in:2083/cpsess0483882715/frontend/paper_lantern/mimeicons/application-x-httpd-php.png\" />&nbsp;add_post_code.php&nbsp;( ASCII C++ program text, with CRLF line terminators )</h1>\r\n\r\n<pre>\r\n &lt;link rel=&quot;stylesheet&quot; href=&quot;https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css&quot;&gt;\r\n &lt;?php \r\n\r\n require_once(&#39;connection.php&#39;);\r\n \r\n\r\n            $post_title=$conn-&gt;real_escape_string($_POST[&#39;post_title&#39;]);\r\n            $post_content=$_POST[&#39;short_desc&#39;];\r\n          \r\n\r\n $uploaded = false;\r\n $filepath_image = &#39;&#39;;\r\nif(isset($_FILES)){\r\n   $filetmp= $_FILES[&quot;post_image&quot;][&quot;tmp_name&quot;];\r\n  $filename_image= $_FILES[&quot;post_image&quot;][&quot;name&quot;];\r\n  $filetype= $_FILES[&quot;', 0, 'blog_images/ej36bjoiDe.jpg', '2020-07-27 13:24:13', 0),
(20, 'jdcnskcnk', '<p>dvjnsjvdvksdmvsjdvmsv</p>\r\n', 0, 'blog_images/amazon_2.jpg', '2020-07-27 13:24:46', 0),
(21, 'hello', '<p><strong><em>jjjjjjjjjjjjjjjjjjjj</em></strong></p>\r\n', 0, 'blog_images/software.png', '2020-07-27 13:27:43', 0);

-- --------------------------------------------------------

--
-- Table structure for table `pc_category`
--

CREATE TABLE `pc_category` (
  `category_id` int(255) NOT NULL,
  `category_name` varchar(255) NOT NULL,
  `disable_flag` varchar(255) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pc_category`
--

INSERT INTO `pc_category` (`category_id`, `category_name`, `disable_flag`) VALUES
(1, 'Android', '0'),
(2, 'App Video', '0'),
(3, 'Apple', '0'),
(4, 'Microsoft', '0'),
(5, 'Trending', '0'),
(6, 'Comics', '0'),
(7, 'Anime', '0'),
(8, 'Cool Gadgets', '0'),
(10, 'Google', '0'),
(11, 'Design', '0'),
(12, 'Developers', '0'),
(13, 'Games', '0'),
(14, 'Facebook', '0'),
(15, 'Instagram', '0'),
(16, 'IOS', '0'),
(17, 'Mobile', '0'),
(18, 'Iphome', '0'),
(19, 'PC', '0'),
(20, 'Sports', '0'),
(21, 'Startups', '0'),
(22, 'Laptops', '0'),
(23, 'Jokes', '0'),
(24, 'Media', '0'),
(25, 'viral', '0'),
(26, 'Announcements', '0'),
(27, 'Linux', '0'),
(28, 'windows', '0'),
(29, 'Mac', '0'),
(30, 'Memes', '0'),
(31, 'News', '0'),
(32, 'India', '0'),
(33, 'AMD', '0'),
(34, 'Intel', '0'),
(35, 'UI/UX', '0'),
(36, 'Machine Learning', '0'),
(37, 'Artificial Intelligence', '0'),
(38, 'Animals', '0'),
(39, 'Industry', '0'),
(40, 'Food', '0'),
(41, 'Travel', '0'),
(42, 'Daily News', '0'),
(43, 'Technology', '0'),
(44, 'Youtube Exporing', '0');

-- --------------------------------------------------------

--
-- Table structure for table `pc_comment`
--

CREATE TABLE `pc_comment` (
  `comment_id` int(255) NOT NULL,
  `blog_id` varchar(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `message` varchar(2000) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `disable_flag` int(20) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pc_comment`
--

INSERT INTO `pc_comment` (`comment_id`, `blog_id`, `name`, `subject`, `email`, `message`, `created_at`, `disable_flag`) VALUES
(1, '5', 'sddssd', 'fvfvvf', 'vssvvs', 'vsss', '2020-04-30 09:48:37', 0),
(2, '1', 'Dinesh Chavan', 'Nice', 'admin@gmail.com', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor labore dolore that magna aliqua. Ut enim ad minim veniam, exercitation.', '2020-04-30 09:49:33', 0),
(3, '2', 'pixa', 'Nice', 'pixeldesigndeveloper@gmail.com', 'Google LLC is an American multinational technology company that specializes in Internet-related services and products, which include online advertising technologies, a search engine, cloud computing, software, and hardware. Wikipedia', '2020-04-30 09:51:12', 0),
(4, '3', 'amit', 'mas', 'admin@gmail.com', ',mfdng', '2020-04-30 17:04:20', 0),
(5, '3', 'Dinesh Chavan', 'Nice', 'yat00674@eoopy.com', 'oooo nice blog', '2020-05-01 05:21:45', 0),
(6, '3', 'sf', 'sdfsd', 'sdfsdf@fhf.bkm', 'wr345', '2020-05-01 05:32:21', 0),
(7, '1', 'Dinesh Chavan', 'Nice', 'admin@gmail.com', 'bbbbb', '2020-05-01 05:34:46', 0),
(12, '1', 'rg', 'Nice', 'admin@dfg.nn', 'gerge', '2020-05-01 05:45:09', 0),
(20, '2', 'pixa', 'sdfsd', 'admin@gmail.com', 'sdfdf', '2020-05-01 07:17:54', 0),
(21, '2', 'pixa', 'sdfsd', 'admin@gmail.com', 'sdfdf', '2020-05-01 07:18:39', 0),
(22, '2', 'bdfb', 'mas', 'admin@gmail.com', 'dfbdfb', '2020-05-01 07:21:17', 0),
(23, '2', 'yat00674@eoopy.com', 'mas', 'admin@gmail.com', 'sdv', '2020-05-01 07:21:54', 0),
(24, '2', 'Dinesh Chavan', 'sdfsd', 'admin@gmail.com', 'sdfsd', '2020-05-01 07:32:12', 0),
(25, '2', 'yat00674@eoopy.com', 'sdfsd', 'admin@gmail.com', 'mm', '2020-05-01 07:32:33', 0),
(26, '11', 'pixa', '454', 'qzb57466@zzrgg.com', 'ss', '2020-05-03 08:42:17', 0),
(27, '12', 'pixa', 'Nice', 'qzb57466@zzrgg.com', 'ddd', '2020-05-03 08:46:19', 0),
(28, '13', 'Dinesh Chavan', 'sdfsd', 'qzb57466@zzrgg.com', 'qzb57466@zzrgg.com', '2020-05-03 08:50:41', 0),
(29, '5', 'Dinesh Chavan', 'amit', 'admin@gmail.com', 'abc', '2020-05-03 08:58:25', 0),
(30, '5', 'Dinesh Chavan', '\'<?php echo $_REQUEST[\"blog_id\"]; ?>\';', 'xxx@fvdb.xom', '\'<\'<?php echo $_REQUEST[\"blog_id\"]; ?>\';', '2020-05-03 09:27:11', 0),
(31, '5', '\'<?php echo $_REQUEST[\"blog_id\"]; ?>\';', '\'<?php echo $_REQUEST[\"blog_id\"]; ?>\';', 'qzb57466@zzrgg.com', '\'<?php echo $_REQUEST[\"blog_id\"]; ?>\';', '2020-05-03 09:28:42', 0),
(32, '5', 'looooks good', '\'<?php echo $_REQUEST[\"blog_id\"]; ?>\';', 'pixeldesigndeveloper@gmail.com', 'htmlspecialchars', '2020-05-03 09:32:58', 0);

-- --------------------------------------------------------

--
-- Table structure for table `pc_contactus`
--

CREATE TABLE `pc_contactus` (
  `contact_id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `message` varchar(1000) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pc_contactus`
--

INSERT INTO `pc_contactus` (`contact_id`, `name`, `email`, `message`, `created_at`) VALUES
(1, 'Dinesh Chavan', 'Dineshchavan2510@gmail.com', 'hello it is too good ', '2020-06-07 05:30:56');

-- --------------------------------------------------------

--
-- Table structure for table `pc_posts`
--

CREATE TABLE `pc_posts` (
  `post_id` int(255) NOT NULL,
  `category_id` int(255) NOT NULL,
  `post_title` varchar(255) NOT NULL,
  `post_description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `post_link` varchar(255) DEFAULT NULL,
  `post_image` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `disable_flag` int(255) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pc_posts`
--

INSERT INTO `pc_posts` (`post_id`, `category_id`, `post_title`, `post_description`, `post_link`, `post_image`, `created_at`, `disable_flag`) VALUES
(1, 4, 'Microsoft ', 'Microsoft Corporation is an American multinational technology company with headquarters in Redmond, Washington. It develops, manufactures, licenses, supports, and sells computer software, consumer electronics, personal computers, and related services. Wik', 'www.microsoft.com', 'post_images/microsoft-logo-redwest-a-100611028-large.jpeg', '2020-03-23 05:24:31', 0),
(2, 10, 'Google', 'Google LLC is an American multinational technology company that specializes in Internet-related services and products, which include online advertising technologies, search engine, cloud computing, software, and hardware. Wikipedia', 'www.google.com', 'post_images/mac-mini-witb-201810.png', '2020-03-23 05:27:30', 0),
(3, 3, 'Apple', 'Apple Inc. is an American multinational technology company headquartered in Cupertino, California, that designs, develops, and sells consumer electronics, computer software, and online services. It is considered one of the Big Four technology companies, alongside Amazon, Google, and Microsoft. Wikipedia', 'www.apple.com', 'post_images/mac-mini-witb-201810.png', '2020-03-23 05:30:38', 0),
(12, 5, 'Amazon', 'Amazon.com, Inc., is an American multinational technology company based in Seattle, with 750,000 employees. It focuses on e-commerce, cloud computing, digital streaming, and artificial intelligence. It is considered one of the Big Four tech companies, along with Google, Apple, and Microsoft.', 'www.amazon.in', 'post_images/411j1k1u9yL._SY355_.jpg', '2020-03-27 14:42:45', 0),
(13, 1, 'jisd', 'apple', 'IUIIU', 'cc', '2020-03-27 14:54:48', 1),
(14, 43, 'Tata', 'Tata Motors Limited, formerly Tata Engineering and Locomotive Company, is an Indian multinational automotive manufacturing company headquartered in Mumbai, Maharashtra, India. It is a part of Tata Group, an Indian conglomerate. ', 'www.tata.com', 'post_images/new-compact-luxury-suv.jpg', '2020-03-27 15:05:01', 0),
(15, 3, 'hello', 'asca', 'ascas', 'post_images/undraw_android_jr64.png', '2020-03-28 07:13:58', 0),
(16, 17, 'Use view binding to replace findViewById', 'New in Android Studio 3.6, view binding gives you the ability to replace findViewById with generated binding objects to simplify code, remove bugs, and avoid all the boilerplate of findViewById. TL;DR Enable view binding in build.gradle (no libraries dependencies) View binding generates a binding object for every layout in your module (activity_awesome.xml → ActivityAwesomeBinding.java) Binding object contains one property for every view with an id in the layout — with the correct type and null-safety Full support for both the Java programming language and Kotlin', 'www.tata.com', 'post_images/1_42FZcmYQhmznt6mIYKKJAw.png', '2020-03-28 08:02:54', 0),
(17, 1, 'Now in Android #14', 'Welcome to Now in Android, your ongoing guide to what’s new and notable in the world of Android development. Hey everyone: I hope everyone is staying safe and healthy. If you’re hunkered down sheltering and working at home like I am these days, maybe you want some developer bits to dive into. Here are some recent pieces from the Android team that are worth checking out. Android 11: Developer Preview 2  Dial it up to Android 11 I talked about the first preview for Android 11 in episode #13. And now, the next release has already dropped. Dave Burke posted an overview of the release on the Android Developers Blog. Check out the preview for updates to some of the features that were already in the release, as well as some new shiny features that are just now available, including my personal favorite feature: IME animation control. Synchronized IME Animations For a platform developer, all new features are like our children: we have no favorites. But really, IME animation control is my favorite-favorite feature. You’ve been asking us for this feature (and we’ve been wanting it ourselves!) for several years, and now it’s here. The idea is that the IME (keyboard) pops up on its own when keyboard entry is needed. This is the functionality the user needs, but it doesn’t provide the experience that users or developers want, because the appearance creates a visual discontinuity by simply popping into place, causing the apps to snap into their adjusted layout given the change in available screen real estate. The keyboard actually does animate in… but the app snaps instantly to the post-animation size, causing this visual hiccup. What developers want, and what the new APIs provide, is the ability to both listen to information about the IME position as it animates in (so that apps can synchronize their own animations to suit) and to control the animation of the IME. Between the listener and the animation control, applications now have enough capability to create experiences that blend the change in the application UI with the animation of the IME itself, providing a much better experience.', 'www', 'post_images/1_-XoC97Y45FKwrGAGICl0yQ.png', '2020-03-29 13:27:16', 0),
(18, 1, 'Migrating to AndroidX: Tip, Tricks, and Guidance', 'Jetpack is a set of libraries, tools, and guidance to help you write high-quality apps more easily. Jetpack makes coding easier through best practices, limiting boilerplate code, and simplifying complex tasks. All with the goal of enabling you to focus on the code that you really care about. AndroidX is the package name for all the libraries within Jetpack. Think of AndroidX as the open-source project used to develop, test, version, and release Jetpack libraries. Back at I/O 2018, we announced that Support Library would be refactored into the AndroidX namespace, which was completed with Support Library 28 and the announcement of AndroidX 1.0. Why migrate? The time is right now to migrate from using the Android Support Library to AndroidX. There are four reasons behind this: The Android Support Library has reached the end of its life. 28.0 was the last release of the Android Support namespace and the namespace is no longer maintained. So, if you want bug fixes or new features that would have previously gone into the Support Library, you need to migrate to AndroidX. Better package management. With AndroidX, you get standardized and independent versioning, as well as better standardized naming and more frequent releases. Other libraries have migrated to use the AndroidX namespace libraries, including Google Play services, Firebase, Butterknife, Mockito 2, and SQLDelight among others. All new Jetpack libraries will be released in AndroidX namespace. So, for example, to take advantage of Jetpack Compose or CameraX, you need to migrate to the AndroidX namespace. Preparing to migrate Before you start to migrate to AndroidX you should: back up your project. If you’re using source control tools, it is still recommended that you make a backup, because migration will change many of the files in your project. create a new branch on which to make the migration changes. if possible, suspend or minimize development (at least don’t try to do refactoring or pull in new features) during the migration, as this will help reduce the number of merge conflicts that could happen. Migrate Throughout the migration steps focus on addressing errors, getting your app to compile, and passing all tests. Step 1: Update to Support Library version 28 Migrating directly to AndroidX from an older version of the Support Library, say 26 or 27, isn’t recommended: not only would you need to address the namespace changes, you would also need to address the API changes between the older version and AndroidX. It is, therefore, recommended that you update to version 28, address all of the API changes, and ensure your app compiles with version 28. Support Library version 28 and AndroidX 1.0 are binary equivalent, meaning that only the package name changes between those two versions: all the APIs are the same. This means that you should have very little to fix when migrating from 28 to AndroidX. Step 2: Enable Jetifier Jetifier helps migrate third-party dependencies to use AndroidX. Jetifier will change the byte code of those dependencies to make them compatible with projects using AndroidX. However, Jetifier won’t change your source code or migrate your generated code. To enable Jetifier in your app, add the following to your gradle.properties files: android.useAndroidX=true android.enableJetifier=true Now, when code auto-completion import libraries, you’ll import the AndroidX version of that library instead of the old Support Library version. Step 3. Update dependencies Before starting the migration, you should update each third-party library — such as Butterknife, Glide, Mockito 2, and SqlDelight — to the most recent version of the library. Not doing so could result in unexplained compilation errors. If you’re using a code generation library, Jetifier won’t modify these. So you will need to check that the code generation library is compatible with AndroidX. If you consider skipping steps 2 and 3 here are some of the errors you could encounter: the third-party code you’re using is not compatible with AndroidX. In this case, a stack trace similar to the one below will show you that it’s trying to pull in the old version of the Support Library: … Error : Program type already present: android.support.v4.app.INotificationSideChannel$Stub$Proxy | Reason: Program type already present: android.support.v4.app.INotificationSideChannel$Stub$Proxy … if you have a project that’s partially migrated, you might get a duplicate class error, where it’s trying to pull in the same code from both the Support Library and AndroidX. The stack trace will show you something like this: … Duplicate class android.support.v4.app.INotificationSideChannel found in modules classes.jar (androidx.core:core:1.0.0) and classes.jar (com.android.support:support-compat:28.0.0) … Step 4: Update your source code You have 3 options to update your source code to use AndroidX: Android Studio manual update Bash script If you use Android Studio 3.2 stable or above, you can update your source code using the Migrate to AndroidX option on the Refactor menu. This is the recommended way as Android Studio can examine your source code to make correct decisions when refactoring.', 'www.w..ww', 'post_images/undraw_android_jr64.png', '2020-03-30 14:23:26', 0),
(19, 1, 'Dagger code generation cheat sheets\r\n', 'Every annotation has a point ?! Check out these cheat sheets to understand how Dagger interprets them and the code it generates for you. Explanations about the generated code and Dagger annotations can be found in the cheat sheets as comments.\r\nFor more information about dependency injection, why you might use Dagger in your Android app, and how to use it, check out the official Android documentation: https://d.android.com/dependency-injection\r\nIf you prefer a step-by-step learning process, check out the Using Dagger in your Android app codelab', 'rrr', 'post_images/0_-1s8WGvw42kUhHJn.png', '2020-03-30 14:33:52', 0),
(20, 1, 'Layout Inspector\r\nDebugging UI hierarchies in Android Studio 4.0+', 'Debugging UI issues can be tricky. Android Studio 4.0 comes with an updated Layout Inspector that lets you debug your Android app UI (user interface) in a way that?s similar to Chrome dev tools. The Layout Inspector works with your device or the Android Emulator and displays the current view hierarchy. This helps pinpoint issues and discover the root causes. Unlike the previous version, the updated Layout Inspector can show the view hierarchy in a 3D perspective which lets you visually see how views are laid out. With this, you can inspect the view hierarchy in layers. It also shows all the view?s attributes including those inherited from its parents.\r\nLet?s see how the latest version of the Layout Inspector works. To open the Layout Inspector click View and select Layout Inspector under the Tool Windows menu. This opens the Layout Inspector window.\r\nOpen the Layout Inspector from the View menu\r\nThe Layout Inspector only displays a UI hierarchy from a running process. This means you need to connect to a debuggable running app on a device or on an emulator. There are two ways to do this:\r\nIf you don?t have a running process, connect to a device or start an Android Emulator instance and click run to start the app.\r\nIf you have a running app process, click on select process, select your running device, and select your running app from the list under the selected running device.', 'dd', 'post_images/1_ezDGReYVx8Qn7MASZqJVGQ.png', '2020-03-30 17:57:54', 0),
(21, 2, 'Inline functions — under the hood\r\n', 'You know all of those Util files you create with all sorts of small functions that you end up using a lot throughout your app? If your utility functions get other functions as parameters, chances are you can improve the performance of your app by saving some extra object allocations, that you might not even know you?re making, with one keyword: inline. Let?s see what happens when you pass these short functions around, what inline does under the hood and what you should be aware of when working with inline functions.\r\nFunction call ? under the hood\r\nLet?s say that you use SharedPreferences a lot in your app so you create this utility function to reduce the boilerplate every time you write something in your SharedPreferences:\r\nfun SharedPreferences.edit(\r\n    commit: Boolean = false,\r\n    action: SharedPreferences.Editor.() -> Unit\r\n) {\r\n    val editor = edit()\r\n    action(editor)\r\n    if (commit) {\r\n        editor.commit()\r\n    } else {\r\n        editor.apply()\r\n    }\r\n}\r\nThen, you can use it to save a String token:\r\nprivate const val KEY_TOKEN = ?token?\r\nclass PreferencesManager(private val preferences: SharedPreferences){\r\n    fun saveToken(token: String) {\r\n        preferences.edit { putString(KEY_TOKEN, token) }\r\n    }\r\n}\r\nNow let?s see what?s going on under the hood when preferences.edit is called. If we look at the Kotlin bytecode (Tools > Kotlin > Decompiled Kotlin to Java) we see that there?s a NEW called, so a new object is being created, even if in our code we didn?t call any object constructor:\r\nNEW com/example/inlinefun/PreferencesManager$saveToken$1', 'www.www.www', 'post_images/1_5QpP21pn8EmDouGf0jAK_Q.png', '2020-03-30 18:05:51', 0),
(22, 44, 'Merge adapters sequentially with MergeAdapter', 'MergeAdapter is a new class available in recyclerview:1.2.0-alpha02 which enables you to sequentially combine multiple adapters to be displayed in a single RecyclerView. This enables you to better encapsulate your adapters rather than having to combine many data sources into a single adapter, keeping them focused and re-usable.\r\nOne use case for this is displaying a list loading state in a header or footer: when the list is retrieving data from the network, we want to show a progress spinner; in case of error, we want to show the error and a retry button.\r\n\r\nA RecyclerView with a footer displaying the loading state: progress or error\r\nIntroducing MergeAdapter\r\nMergeAdapter allows us to display the contents of multiple adapters, in a sequence. For example, let?s say that we have the following 3 adapters:\r\nval firstAdapter: FirstAdapter = ?\r\nval secondAdapter: SecondAdapter = ?\r\nval thirdAdapter: ThirdAdapter = ?\r\nval mergeAdapter = MergeAdapter(firstAdapter, secondAdapter, \r\n     thirdAdapter)\r\nrecyclerView.adapter = mergeAdapter\r\nThe recyclerView will display the items from each adapter sequentially.\r\nHaving different adapters allows you to better separate the concerns of each sequential part of a list. For example, if you want to display a header, you don?t need to put the logic related to the header display in the same adapter that handles the list display, rather you can encapsulate it in its own adapter.\r\n', 'www.yt.com', 'post_images/0_dVXw_ylmIfbVvZkQ.png', '2020-03-31 05:38:26', 0),
(23, 20, 'Intel’s 10th Generation H-Series Core CPUs, ‘Comet Lake-H,’ Arrive in Laptops This Month', 'The most powerful processor in the new family is the Intel Core i9?10980HK, an unlocked eight-core, 16-thread beast that boosts to single-core clock speeds of up to 5.3GHz.By Michael KanStarting later this month, PC vendors will unleash new laptops for gamers and power users with Intel?s latest chip family: the 10th Generation Core H-Series processors.The range of six new chips, code-named in the run-up to their release as ?Comet Lake-H,? starts with a Core i5 processor and scales all the way up to a Core i9, which can be overclocked to break the 5GHz barrier. According to Intel, the silicon will be packed inside more than 100 upcoming notebook designs, including gaming laptops.The only problem is the coronavirus; Intel says the ongoing pandemic has been disrupting the supply chain in Asia, so the volume of new laptops using the chips will take longer to materialize. Expect the first models to show up for sale or for pre-order on April 15.?Comet Lake-H?: The Return of 14nmAlthough Intel is lumping the new chips into its 10th Generation line, the processors actually use a further refinement of the older 14-nanometer (nm) manufacturing process, which the company has been relying on for years as it has struggled to transition quickly to 10nm process technology.H-Series chips are traditionally Intel?s top-end mobile processors for robust laptops. The chip maker has already debuted 10nm, lower-power chips in its U-Series in another 10th Generation family, code-named ?Ice Lake.? These chips are designed for thin-design, premium-priced laptops, while these H-Series processors are meant for thicker, power-minded machines and gaming models. Also already on the market are 10th Generation U-Series chips employing the 14nm process, under the code-name ?Comet Lake-U.?', 'www.tata.com', 'post_images/intel.jpg', '2020-03-31 05:57:01', 0),
(24, 2, 'youtube', 'YouTube is an American online video-sharing platform headquartered in San Bruno, California. Three former PayPal employees—Chad Hurley, Steve Chen, and Jawed Karim—created the service in February 2005. Google bought the site in November 2006 for US$1.65 billion; YouTube now operates as one of Google\'s subsidiaries. Wikipedia', 'ww.yt.com', 'post_images/youtube.png', '2020-04-03 08:59:53', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_data`
--

CREATE TABLE `user_data` (
  `user_id` int(200) NOT NULL,
  `first_name` varchar(200) NOT NULL,
  `last_name` varchar(1000) DEFAULT NULL,
  `password` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `detail` varchar(200) NOT NULL,
  `phone` varchar(200) NOT NULL,
  `active` varchar(1000) NOT NULL,
  `token` varchar(1000) NOT NULL,
  `disable_flag` int(255) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_data`
--

INSERT INTO `user_data` (`user_id`, `first_name`, `last_name`, `password`, `email`, `detail`, `phone`, `active`, `token`, `disable_flag`) VALUES
(1, 'John', 'Wick', '0000', 'dineshchavan2510@gmail.com', 'jj', '', 'Yes', '', 0),
(2, 'Dinesh', 'Wick', '000', 'dineshchavan2510@gmail.com', 'ee', '', '6292848475eb7d14a0acf87.88399907', '', 0),
(3, 'Dinesh ', 'Chavan', '000', 'dineshchavan2510@gmail.com', '0000', '', '1021031255eb7d22e6cb4f7.62814791', '', 0),
(4, '00', '00', '0000', 'dineshchavan2510@gmail.com', '00', '', '9956263985eb7d27c963934.81372294', '', 0),
(5, '00', '00', '0000', 'dineshchavan2510@gmail.com', '00', '', 'Yes', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `user_id` int(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `contact_no` varchar(200) NOT NULL,
  `user_image` varchar(10000) NOT NULL,
  `birthday` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `added_date` datetime NOT NULL DEFAULT current_timestamp(),
  `disable_flag` int(255) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`user_id`, `name`, `email`, `contact_no`, `user_image`, `birthday`, `password`, `added_date`, `disable_flag`) VALUES
(1, '$name', '$email', '0', '', '$birthday', '$password', '2019-12-16 22:13:08', 1),
(2, 'Dinesh Chavan', 'pixeldesigndeveloper@gmail.com', '2147483647', '', '2019-12-24', '1234', '2019-12-16 22:20:05', 1),
(3, 'xbg02149@bcaoo.com', 'pixeldesigndeveloper@gmail.com', '2147483647', '', '2019-12-16', '11212', '2019-12-16 23:05:55', 1),
(4, '4444', 'leq67817@eveav.com', '202020', '', '', '1', '2019-12-16 23:07:08', 1),
(5, 'Dinesh', 'pixeldesigndeveloper@gmail.com', '8433895445', '', '', '1', '2019-12-16 23:08:13', 1),
(6, 'admin', 'admin@gmail.com', '9221437768', '', '1997-10-25', '1234', '2020-03-03 11:30:46', 1),
(10, 'name', 'emal', '', '', '', 'password', '2020-03-07 16:53:47', 1),
(11, 'ggggg', 'vvb', '', '', '', 'ggggb', '2020-03-07 17:04:00', 1),
(12, 'ggggg', 'vvb', '', '', '', 'ggggb', '2020-03-07 17:04:31', 1),
(13, 'ggggg', 'vvb', '', '', '', 'ggggb3.', '2020-03-07 17:07:38', 1),
(14, 'ggggg', 'vvb', '', '', '', 'ggggb3.', '2020-03-07 17:07:38', 1),
(15, 'ggggg', 'vvb', '', '', '', 'ggggb3.', '2020-03-07 17:07:38', 1),
(16, 'ggggg', 'vvb', '', '', '', 'ggggb3.', '2020-03-07 17:07:39', 1),
(17, 'ggggg', 'vvb', '', '', '', 'ggggb3.', '2020-03-07 17:07:39', 1),
(18, 'Dinesh', 'Chavana@gmail.com', '88855555555', 'user_images/keyborad.jpg', '', '78', '2020-03-07 17:07:39', 0),
(19, 'aaaaaa', 'qzb57466@zzrgg.com', 'phone', 'user_images/DIGITAL READER.png', '', 'addressbbbbbb ', '2020-05-16 18:35:14', 0),
(20, 'Dinesh_Vishal', 'qzb57466@zzrgg.com', 'phone', 'user_images/ic_verified.png', '', 'address', '2020-05-16 20:22:07', 0),
(21, 'Dinesh_Vishal', 'dineshchavan2510@gmail.com', 'phone', 'user_images/robo.jpg', '', 'address', '2020-05-16 20:24:15', 0),
(22, 'Dinesh_Vishal', 'pixeldesigndeveloper@gmail.com', 'phone', 'user_images/keyborad.jpg', '', 'address', '2020-05-16 20:29:48', 0),
(23, 'Dinesh_Vishal', 'pixeldesigndeveloper@gmail.com', 'phone', 'user_images/keyborad.jpg', '', 'address', '2020-05-16 20:30:12', 0),
(24, 'admin', 'qzb57466@zzrgg.com', 'phone', 'user_images/bandwidth-close-up-computer-connection-1148820.jpg', '', 'addressbbbbbb ', '2020-05-16 20:33:08', 0),
(25, 'Dinesh_Vishal', 'qzb57466@zzrgg.com', 'phone', 'user_images/robo.jpg', '', 'address', '2020-05-16 20:34:06', 1),
(26, 'adminaaaaaaaaa', 'dineshchavan2510@gmail.com', 'phone', 'user_images/signal-coverage.png', '', 'address', '2020-05-16 20:34:37', 0),
(27, 'Dinesh Chavan', 'dineshchavan2510@gmail.com', '7858685555', 'user_images/technology.png', '', 'addressbbbbbb ', '2020-05-16 23:01:40', 0),
(28, 'Dinesh', 'qzb57466@zzrgg.com', '78787878', 'user_images/unnamed.webp', '', '26/4 shanti kurpa building ganesh nagar dombivali west ', '2020-05-16 23:03:59', 0),
(29, 'John Wick ', 'johnWick@gmail.com', '777777777', 'user_images/apple-iphone-12-pro-max-r2.jpg', '', 'john wicj ', '2020-05-19 18:42:09', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adview_data`
--
ALTER TABLE `adview_data`
  ADD PRIMARY KEY (`adview_id`);

--
-- Indexes for table `app_post`
--
ALTER TABLE `app_post`
  ADD PRIMARY KEY (`post_id`);

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`memberID`);

--
-- Indexes for table `pc_blog`
--
ALTER TABLE `pc_blog`
  ADD PRIMARY KEY (`blog_id`);

--
-- Indexes for table `pc_category`
--
ALTER TABLE `pc_category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `pc_comment`
--
ALTER TABLE `pc_comment`
  ADD PRIMARY KEY (`comment_id`);

--
-- Indexes for table `pc_contactus`
--
ALTER TABLE `pc_contactus`
  ADD PRIMARY KEY (`contact_id`);

--
-- Indexes for table `pc_posts`
--
ALTER TABLE `pc_posts`
  ADD PRIMARY KEY (`post_id`);

--
-- Indexes for table `user_data`
--
ALTER TABLE `user_data`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adview_data`
--
ALTER TABLE `adview_data`
  MODIFY `adview_id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `app_post`
--
ALTER TABLE `app_post`
  MODIFY `post_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `memberID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pc_blog`
--
ALTER TABLE `pc_blog`
  MODIFY `blog_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `pc_category`
--
ALTER TABLE `pc_category`
  MODIFY `category_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `pc_comment`
--
ALTER TABLE `pc_comment`
  MODIFY `comment_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `pc_contactus`
--
ALTER TABLE `pc_contactus`
  MODIFY `contact_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pc_posts`
--
ALTER TABLE `pc_posts`
  MODIFY `post_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `user_data`
--
ALTER TABLE `user_data`
  MODIFY `user_id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `user_id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
