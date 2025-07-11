PGDMP      !                }           events-organizer    17.5    17.5 Q    ]           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            ^           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            _           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            `           1262    16556    events-organizer    DATABASE     x   CREATE DATABASE "events-organizer" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'bg-BG';
 "   DROP DATABASE "events-organizer";
                     postgres    false            �            1259    24757    event_attendants    TABLE     k   CREATE TABLE public.event_attendants (
    event_id integer NOT NULL,
    attendant_id integer NOT NULL
);
 $   DROP TABLE public.event_attendants;
       public         heap r       postgres    false            �            1259    24762    event_followers    TABLE     j   CREATE TABLE public.event_followers (
    event_id integer NOT NULL,
    followers_id integer NOT NULL
);
 #   DROP TABLE public.event_followers;
       public         heap r       postgres    false            �            1259    24767    event_sponsors    TABLE     g   CREATE TABLE public.event_sponsors (
    event_id integer NOT NULL,
    sponsor_id integer NOT NULL
);
 "   DROP TABLE public.event_sponsors;
       public         heap r       postgres    false            �            1259    16558    events    TABLE     �  CREATE TABLE public.events (
    id integer NOT NULL,
    category character varying(255),
    description character varying(255),
    end_date timestamp(6) without time zone,
    location character varying(255),
    organizer_id integer,
    rules character varying(255),
    sponsor_id integer,
    start_date timestamp(6) without time zone,
    title character varying(255),
    image_url character varying(255),
    likes integer,
    attendant_id integer,
    followers integer,
    visitors integer
);
    DROP TABLE public.events;
       public         heap r       postgres    false            �            1259    16557    events_id_seq    SEQUENCE     �   CREATE SEQUENCE public.events_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.events_id_seq;
       public               postgres    false    218            a           0    0    events_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.events_id_seq OWNED BY public.events.id;
          public               postgres    false    217            �            1259    16567 
   invitation    TABLE     �   CREATE TABLE public.invitation (
    id integer NOT NULL,
    event_id integer NOT NULL,
    status character varying(255) NOT NULL,
    sent_at timestamp(6) without time zone,
    receiver_id integer,
    sender_id integer
);
    DROP TABLE public.invitation;
       public         heap r       postgres    false            �            1259    16566    invitation_id_seq    SEQUENCE     �   CREATE SEQUENCE public.invitation_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.invitation_id_seq;
       public               postgres    false    220            b           0    0    invitation_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.invitation_id_seq OWNED BY public.invitation.id;
          public               postgres    false    219            �            1259    16574    media_content    TABLE     �   CREATE TABLE public.media_content (
    id integer NOT NULL,
    caption character varying(255) NOT NULL,
    event_id integer NOT NULL,
    type character varying(255) NOT NULL,
    upload_date timestamp(6) without time zone NOT NULL
);
 !   DROP TABLE public.media_content;
       public         heap r       postgres    false            �            1259    16573    media_content_id_seq    SEQUENCE     �   CREATE SEQUENCE public.media_content_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.media_content_id_seq;
       public               postgres    false    222            c           0    0    media_content_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.media_content_id_seq OWNED BY public.media_content.id;
          public               postgres    false    221            �            1259    16583    notification    TABLE       CREATE TABLE public.notification (
    id integer NOT NULL,
    event_id integer NOT NULL,
    is_received boolean NOT NULL,
    message_content character varying(255) NOT NULL,
    send_at timestamp(6) without time zone NOT NULL,
    user_id integer NOT NULL
);
     DROP TABLE public.notification;
       public         heap r       postgres    false            �            1259    16582    notification_id_seq    SEQUENCE     �   CREATE SEQUENCE public.notification_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.notification_id_seq;
       public               postgres    false    224            d           0    0    notification_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.notification_id_seq OWNED BY public.notification.id;
          public               postgres    false    223            �            1259    16590    ticket    TABLE     s   CREATE TABLE public.ticket (
    id integer NOT NULL,
    event_id integer NOT NULL,
    price integer NOT NULL
);
    DROP TABLE public.ticket;
       public         heap r       postgres    false            �            1259    16589    ticket_id_seq    SEQUENCE     �   CREATE SEQUENCE public.ticket_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.ticket_id_seq;
       public               postgres    false    226            e           0    0    ticket_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.ticket_id_seq OWNED BY public.ticket.id;
          public               postgres    false    225            �            1259    24824    user_followed_events    TABLE     j   CREATE TABLE public.user_followed_events (
    user_id integer NOT NULL,
    event_id integer NOT NULL
);
 (   DROP TABLE public.user_followed_events;
       public         heap r       postgres    false            �            1259    24829    user_liked_events    TABLE     g   CREATE TABLE public.user_liked_events (
    user_id integer NOT NULL,
    event_id integer NOT NULL
);
 %   DROP TABLE public.user_liked_events;
       public         heap r       postgres    false            �            1259    24834    user_visited_events    TABLE     i   CREATE TABLE public.user_visited_events (
    user_id integer NOT NULL,
    event_id integer NOT NULL
);
 '   DROP TABLE public.user_visited_events;
       public         heap r       postgres    false            �            1259    16597    users    TABLE       CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    role character varying(255),
    username character varying(255)
);
    DROP TABLE public.users;
       public         heap r       postgres    false            �            1259    16596    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public               postgres    false    228            f           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public               postgres    false    227            �           2604    16561 	   events id    DEFAULT     f   ALTER TABLE ONLY public.events ALTER COLUMN id SET DEFAULT nextval('public.events_id_seq'::regclass);
 8   ALTER TABLE public.events ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    218    217    218            �           2604    16570    invitation id    DEFAULT     n   ALTER TABLE ONLY public.invitation ALTER COLUMN id SET DEFAULT nextval('public.invitation_id_seq'::regclass);
 <   ALTER TABLE public.invitation ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    220    219    220            �           2604    16577    media_content id    DEFAULT     t   ALTER TABLE ONLY public.media_content ALTER COLUMN id SET DEFAULT nextval('public.media_content_id_seq'::regclass);
 ?   ALTER TABLE public.media_content ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    221    222    222            �           2604    16586    notification id    DEFAULT     r   ALTER TABLE ONLY public.notification ALTER COLUMN id SET DEFAULT nextval('public.notification_id_seq'::regclass);
 >   ALTER TABLE public.notification ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    223    224    224            �           2604    16593 	   ticket id    DEFAULT     f   ALTER TABLE ONLY public.ticket ALTER COLUMN id SET DEFAULT nextval('public.ticket_id_seq'::regclass);
 8   ALTER TABLE public.ticket ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    226    225    226            �           2604    16600    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    228    227    228            U          0    24757    event_attendants 
   TABLE DATA           B   COPY public.event_attendants (event_id, attendant_id) FROM stdin;
    public               postgres    false    229   �e       V          0    24762    event_followers 
   TABLE DATA           A   COPY public.event_followers (event_id, followers_id) FROM stdin;
    public               postgres    false    230   �e       W          0    24767    event_sponsors 
   TABLE DATA           >   COPY public.event_sponsors (event_id, sponsor_id) FROM stdin;
    public               postgres    false    231   �e       J          0    16558    events 
   TABLE DATA           �   COPY public.events (id, category, description, end_date, location, organizer_id, rules, sponsor_id, start_date, title, image_url, likes, attendant_id, followers, visitors) FROM stdin;
    public               postgres    false    218   f       L          0    16567 
   invitation 
   TABLE DATA           [   COPY public.invitation (id, event_id, status, sent_at, receiver_id, sender_id) FROM stdin;
    public               postgres    false    220   �g       N          0    16574    media_content 
   TABLE DATA           Q   COPY public.media_content (id, caption, event_id, type, upload_date) FROM stdin;
    public               postgres    false    222   :h       P          0    16583    notification 
   TABLE DATA           d   COPY public.notification (id, event_id, is_received, message_content, send_at, user_id) FROM stdin;
    public               postgres    false    224   Wh       R          0    16590    ticket 
   TABLE DATA           5   COPY public.ticket (id, event_id, price) FROM stdin;
    public               postgres    false    226   th       X          0    24824    user_followed_events 
   TABLE DATA           A   COPY public.user_followed_events (user_id, event_id) FROM stdin;
    public               postgres    false    232   �h       Y          0    24829    user_liked_events 
   TABLE DATA           >   COPY public.user_liked_events (user_id, event_id) FROM stdin;
    public               postgres    false    233   �h       Z          0    24834    user_visited_events 
   TABLE DATA           @   COPY public.user_visited_events (user_id, event_id) FROM stdin;
    public               postgres    false    234   �h       T          0    16597    users 
   TABLE DATA           [   COPY public.users (id, email, first_name, last_name, password, role, username) FROM stdin;
    public               postgres    false    228   i       g           0    0    events_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.events_id_seq', 3, true);
          public               postgres    false    217            h           0    0    invitation_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.invitation_id_seq', 20, true);
          public               postgres    false    219            i           0    0    media_content_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.media_content_id_seq', 1, false);
          public               postgres    false    221            j           0    0    notification_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.notification_id_seq', 1, false);
          public               postgres    false    223            k           0    0    ticket_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.ticket_id_seq', 1, false);
          public               postgres    false    225            l           0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 4, true);
          public               postgres    false    227            �           2606    24761 &   event_attendants event_attendants_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.event_attendants
    ADD CONSTRAINT event_attendants_pkey PRIMARY KEY (event_id, attendant_id);
 P   ALTER TABLE ONLY public.event_attendants DROP CONSTRAINT event_attendants_pkey;
       public                 postgres    false    229    229            �           2606    24766 $   event_followers event_followers_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY public.event_followers
    ADD CONSTRAINT event_followers_pkey PRIMARY KEY (event_id, followers_id);
 N   ALTER TABLE ONLY public.event_followers DROP CONSTRAINT event_followers_pkey;
       public                 postgres    false    230    230            �           2606    24771 "   event_sponsors event_sponsors_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.event_sponsors
    ADD CONSTRAINT event_sponsors_pkey PRIMARY KEY (event_id, sponsor_id);
 L   ALTER TABLE ONLY public.event_sponsors DROP CONSTRAINT event_sponsors_pkey;
       public                 postgres    false    231    231            �           2606    16565    events events_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.events
    ADD CONSTRAINT events_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.events DROP CONSTRAINT events_pkey;
       public                 postgres    false    218            �           2606    16572    invitation invitation_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.invitation
    ADD CONSTRAINT invitation_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.invitation DROP CONSTRAINT invitation_pkey;
       public                 postgres    false    220            �           2606    16581     media_content media_content_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.media_content
    ADD CONSTRAINT media_content_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.media_content DROP CONSTRAINT media_content_pkey;
       public                 postgres    false    222            �           2606    16588    notification notification_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.notification
    ADD CONSTRAINT notification_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.notification DROP CONSTRAINT notification_pkey;
       public                 postgres    false    224            �           2606    16595    ticket ticket_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.ticket DROP CONSTRAINT ticket_pkey;
       public                 postgres    false    226            �           2606    24773 -   event_attendants uk_b4p3ta7hkox8ole9ov98u1grb 
   CONSTRAINT     p   ALTER TABLE ONLY public.event_attendants
    ADD CONSTRAINT uk_b4p3ta7hkox8ole9ov98u1grb UNIQUE (attendant_id);
 W   ALTER TABLE ONLY public.event_attendants DROP CONSTRAINT uk_b4p3ta7hkox8ole9ov98u1grb;
       public                 postgres    false    229            �           2606    24828 .   user_followed_events user_followed_events_pkey 
   CONSTRAINT     {   ALTER TABLE ONLY public.user_followed_events
    ADD CONSTRAINT user_followed_events_pkey PRIMARY KEY (user_id, event_id);
 X   ALTER TABLE ONLY public.user_followed_events DROP CONSTRAINT user_followed_events_pkey;
       public                 postgres    false    232    232            �           2606    24833 (   user_liked_events user_liked_events_pkey 
   CONSTRAINT     u   ALTER TABLE ONLY public.user_liked_events
    ADD CONSTRAINT user_liked_events_pkey PRIMARY KEY (user_id, event_id);
 R   ALTER TABLE ONLY public.user_liked_events DROP CONSTRAINT user_liked_events_pkey;
       public                 postgres    false    233    233            �           2606    24838 ,   user_visited_events user_visited_events_pkey 
   CONSTRAINT     y   ALTER TABLE ONLY public.user_visited_events
    ADD CONSTRAINT user_visited_events_pkey PRIMARY KEY (user_id, event_id);
 V   ALTER TABLE ONLY public.user_visited_events DROP CONSTRAINT user_visited_events_pkey;
       public                 postgres    false    234    234            �           2606    16604    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public                 postgres    false    228            �           2606    24859 /   user_visited_events fk4rm9fmgsfvg8lc4ul7j742bpa    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_visited_events
    ADD CONSTRAINT fk4rm9fmgsfvg8lc4ul7j742bpa FOREIGN KEY (event_id) REFERENCES public.events(id);
 Y   ALTER TABLE ONLY public.user_visited_events DROP CONSTRAINT fk4rm9fmgsfvg8lc4ul7j742bpa;
       public               postgres    false    234    4751    218            �           2606    24799 *   event_sponsors fk5olsee36eb239q1xavgjibrhs    FK CONSTRAINT     �   ALTER TABLE ONLY public.event_sponsors
    ADD CONSTRAINT fk5olsee36eb239q1xavgjibrhs FOREIGN KEY (event_id) REFERENCES public.events(id);
 T   ALTER TABLE ONLY public.event_sponsors DROP CONSTRAINT fk5olsee36eb239q1xavgjibrhs;
       public               postgres    false    4751    218    231            �           2606    24849 -   user_liked_events fk5pb3vkfn5us0wfrklc1mfa88v    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_liked_events
    ADD CONSTRAINT fk5pb3vkfn5us0wfrklc1mfa88v FOREIGN KEY (event_id) REFERENCES public.events(id);
 W   ALTER TABLE ONLY public.user_liked_events DROP CONSTRAINT fk5pb3vkfn5us0wfrklc1mfa88v;
       public               postgres    false    218    233    4751            �           2606    24839 0   user_followed_events fk77b1elb9tipfucpv2co08onjf    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_followed_events
    ADD CONSTRAINT fk77b1elb9tipfucpv2co08onjf FOREIGN KEY (event_id) REFERENCES public.events(id);
 Z   ALTER TABLE ONLY public.user_followed_events DROP CONSTRAINT fk77b1elb9tipfucpv2co08onjf;
       public               postgres    false    218    4751    232            �           2606    24864 /   user_visited_events fk7y1w3jfve9lw3c3jy1be8n2gx    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_visited_events
    ADD CONSTRAINT fk7y1w3jfve9lw3c3jy1be8n2gx FOREIGN KEY (user_id) REFERENCES public.users(id);
 Y   ALTER TABLE ONLY public.user_visited_events DROP CONSTRAINT fk7y1w3jfve9lw3c3jy1be8n2gx;
       public               postgres    false    234    228    4761            �           2606    24819 &   invitation fk8qamsp0em5ub7edqfww44h3ix    FK CONSTRAINT     �   ALTER TABLE ONLY public.invitation
    ADD CONSTRAINT fk8qamsp0em5ub7edqfww44h3ix FOREIGN KEY (sender_id) REFERENCES public.users(id);
 P   ALTER TABLE ONLY public.invitation DROP CONSTRAINT fk8qamsp0em5ub7edqfww44h3ix;
       public               postgres    false    220    4761    228            �           2606    24844 0   user_followed_events fkanmj538g8iffn8vdmt5y9lxym    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_followed_events
    ADD CONSTRAINT fkanmj538g8iffn8vdmt5y9lxym FOREIGN KEY (user_id) REFERENCES public.users(id);
 Z   ALTER TABLE ONLY public.user_followed_events DROP CONSTRAINT fkanmj538g8iffn8vdmt5y9lxym;
       public               postgres    false    228    232    4761            �           2606    24804 "   events fkdocju8m76a3f8o6ljh2jrn2ra    FK CONSTRAINT     �   ALTER TABLE ONLY public.events
    ADD CONSTRAINT fkdocju8m76a3f8o6ljh2jrn2ra FOREIGN KEY (organizer_id) REFERENCES public.users(id);
 L   ALTER TABLE ONLY public.events DROP CONSTRAINT fkdocju8m76a3f8o6ljh2jrn2ra;
       public               postgres    false    228    218    4761            �           2606    24774 ,   event_attendants fkfhr9wy24yqqthtxrdnqkkwh0d    FK CONSTRAINT     �   ALTER TABLE ONLY public.event_attendants
    ADD CONSTRAINT fkfhr9wy24yqqthtxrdnqkkwh0d FOREIGN KEY (attendant_id) REFERENCES public.users(id);
 V   ALTER TABLE ONLY public.event_attendants DROP CONSTRAINT fkfhr9wy24yqqthtxrdnqkkwh0d;
       public               postgres    false    229    228    4761            �           2606    24854 -   user_liked_events fkg62775lf4fr5rof7xknnhvd8g    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_liked_events
    ADD CONSTRAINT fkg62775lf4fr5rof7xknnhvd8g FOREIGN KEY (user_id) REFERENCES public.users(id);
 W   ALTER TABLE ONLY public.user_liked_events DROP CONSTRAINT fkg62775lf4fr5rof7xknnhvd8g;
       public               postgres    false    4761    228    233            �           2606    24814 &   invitation fkgnf21don63dhi6kd84yy9uqx2    FK CONSTRAINT     �   ALTER TABLE ONLY public.invitation
    ADD CONSTRAINT fkgnf21don63dhi6kd84yy9uqx2 FOREIGN KEY (receiver_id) REFERENCES public.users(id);
 P   ALTER TABLE ONLY public.invitation DROP CONSTRAINT fkgnf21don63dhi6kd84yy9uqx2;
       public               postgres    false    220    4761    228            �           2606    24809 &   invitation fkjlhncqm9351scp9mpk6db7xut    FK CONSTRAINT     �   ALTER TABLE ONLY public.invitation
    ADD CONSTRAINT fkjlhncqm9351scp9mpk6db7xut FOREIGN KEY (event_id) REFERENCES public.events(id);
 P   ALTER TABLE ONLY public.invitation DROP CONSTRAINT fkjlhncqm9351scp9mpk6db7xut;
       public               postgres    false    218    220    4751            �           2606    24784 +   event_followers fko018dxksbov2yxsre3pba8kfc    FK CONSTRAINT     �   ALTER TABLE ONLY public.event_followers
    ADD CONSTRAINT fko018dxksbov2yxsre3pba8kfc FOREIGN KEY (followers_id) REFERENCES public.users(id);
 U   ALTER TABLE ONLY public.event_followers DROP CONSTRAINT fko018dxksbov2yxsre3pba8kfc;
       public               postgres    false    230    228    4761            �           2606    24794 *   event_sponsors fkogtkfk6lkwcg3xwxmtciuy07p    FK CONSTRAINT     �   ALTER TABLE ONLY public.event_sponsors
    ADD CONSTRAINT fkogtkfk6lkwcg3xwxmtciuy07p FOREIGN KEY (sponsor_id) REFERENCES public.users(id);
 T   ALTER TABLE ONLY public.event_sponsors DROP CONSTRAINT fkogtkfk6lkwcg3xwxmtciuy07p;
       public               postgres    false    228    4761    231            �           2606    24789 +   event_followers fkpvxs5u4b1kleyqrtifee6yf4g    FK CONSTRAINT     �   ALTER TABLE ONLY public.event_followers
    ADD CONSTRAINT fkpvxs5u4b1kleyqrtifee6yf4g FOREIGN KEY (event_id) REFERENCES public.events(id);
 U   ALTER TABLE ONLY public.event_followers DROP CONSTRAINT fkpvxs5u4b1kleyqrtifee6yf4g;
       public               postgres    false    218    4751    230            �           2606    24779 ,   event_attendants fks5jpv1rgmpvg4qmhrvd9yho7x    FK CONSTRAINT     �   ALTER TABLE ONLY public.event_attendants
    ADD CONSTRAINT fks5jpv1rgmpvg4qmhrvd9yho7x FOREIGN KEY (event_id) REFERENCES public.events(id);
 V   ALTER TABLE ONLY public.event_attendants DROP CONSTRAINT fks5jpv1rgmpvg4qmhrvd9yho7x;
       public               postgres    false    4751    218    229            U      x������ � �      V      x������ � �      W      x������ � �      J   �  x�M�KN�0�דS�H�^�!�q 6�:iH�Pl@�xI6�Gp��ZZ�0�cSQ�H�x��,�WEY�����d$W�h=�JَE;��Hu�U��P(�SY����W���B���O; �)� z�}�M��1��%��R�D�4�wwi�Y2��4C{a�Ѱ��!�^��)2����k{��+>��`Q��&F��^�\:z��{�no>	�;�组�¢k݃tDM��}��t�˳��g�h��}{s�������3�]F^�����;�:?�M,��=W`���O�Os���`x\&&�ɵѭ���P���<���R}S1��T��� �2�ƔJcR��S�i-�{^��y���a�Ye����<��aBJo 2�oA�:��@      L   |   x�uλ�0E�Z�"� ���X'� ��9Ni�W�Hy?��k0l��Xn�R-%]�
J���S{�w��icaG�'�ZL,��k;�F�Ƶ��5MIY��ς�-Zbds
w�c�C��/�2�      N      x������ � �      P      x������ � �      R      x������ � �      X      x�3�4�2�4�2�1z\\\ C      Y      x�3�4�2�4�2�1z\\\ C      Z      x�3�4�2�4�2�1z\\\ C      T   �   x�3��(�,���HsH�M���K���� 	q�%g椖%��%�y��&�E�y)@i@Fz~Y"�g^jyhqj�v?�H^bn*��X\��CU��1��q9d'��&Ό�4C3#cN�C�=... QA�     