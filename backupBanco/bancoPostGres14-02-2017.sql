--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 9.6.1

-- Started on 2017-02-14 19:16:43

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 16394)
-- Name: avalicacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE avalicacao (
    estrelas integer,
    id_usuario integer,
    id integer
);


ALTER TABLE avalicacao OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 32903)
-- Name: carona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE carona (
    id integer NOT NULL,
    grupo_id integer,
    veiculo_id integer,
    data character varying,
    horariosaida character varying,
    num_vagas integer,
    logorigem_id integer,
    logdestino_id integer
);


ALTER TABLE carona OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 32901)
-- Name: carona_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE carona_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE carona_id_seq OWNER TO postgres;

--
-- TOC entry 2205 (class 0 OID 0)
-- Dependencies: 199
-- Name: carona_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE carona_id_seq OWNED BY carona.id;


--
-- TOC entry 196 (class 1259 OID 32872)
-- Name: grupo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE grupo (
    id integer NOT NULL,
    nome character varying,
    descricao character varying,
    regra character varying,
    limite integer
);


ALTER TABLE grupo OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 32870)
-- Name: grupo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE grupo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE grupo_id_seq OWNER TO postgres;

--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 195
-- Name: grupo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE grupo_id_seq OWNED BY grupo.id;


--
-- TOC entry 186 (class 1259 OID 32798)
-- Name: lagradouro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE lagradouro (
    id integer NOT NULL,
    cep character varying,
    estado character varying,
    cidade character varying,
    distrito character varying,
    endereco character varying,
    numero integer
);


ALTER TABLE lagradouro OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 32832)
-- Name: nova; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE nova (
    id integer NOT NULL,
    nome character varying
);


ALTER TABLE nova OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 32830)
-- Name: nova_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE nova_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE nova_id_seq OWNER TO postgres;

--
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 190
-- Name: nova_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE nova_id_seq OWNED BY nova.id;


--
-- TOC entry 187 (class 1259 OID 32814)
-- Name: parada; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE parada (
    usuario_id integer,
    carona_id integer,
    lagradouro_id integer
);


ALTER TABLE parada OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 32819)
-- Name: test; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE test (
    a integer NOT NULL,
    b text
);


ALTER TABLE test OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 32817)
-- Name: test_a_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE test_a_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE test_a_seq OWNER TO postgres;

--
-- TOC entry 2208 (class 0 OID 0)
-- Dependencies: 188
-- Name: test_a_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE test_a_seq OWNED BY test.a;


--
-- TOC entry 193 (class 1259 OID 32851)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuario (
    id integer NOT NULL,
    nome character varying,
    email character varying,
    telefone character varying
);


ALTER TABLE usuario OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 32858)
-- Name: usuario_grupo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuario_grupo (
    usuario_id integer,
    grupo_id integer,
    situacao character varying
);


ALTER TABLE usuario_grupo OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 32849)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario_id_seq OWNER TO postgres;

--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 192
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuario_id_seq OWNED BY usuario.id;


--
-- TOC entry 198 (class 1259 OID 32884)
-- Name: veiculo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE veiculo (
    id integer NOT NULL,
    modelo character varying,
    placa character varying,
    cor character varying,
    usuario_id integer
);


ALTER TABLE veiculo OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 32882)
-- Name: veiculo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE veiculo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE veiculo_id_seq OWNER TO postgres;

--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 197
-- Name: veiculo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE veiculo_id_seq OWNED BY veiculo.id;


--
-- TOC entry 2060 (class 2604 OID 32906)
-- Name: carona id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY carona ALTER COLUMN id SET DEFAULT nextval('carona_id_seq'::regclass);


--
-- TOC entry 2058 (class 2604 OID 32875)
-- Name: grupo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY grupo ALTER COLUMN id SET DEFAULT nextval('grupo_id_seq'::regclass);


--
-- TOC entry 2056 (class 2604 OID 32835)
-- Name: nova id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY nova ALTER COLUMN id SET DEFAULT nextval('nova_id_seq'::regclass);


--
-- TOC entry 2055 (class 2604 OID 32822)
-- Name: test a; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY test ALTER COLUMN a SET DEFAULT nextval('test_a_seq'::regclass);


--
-- TOC entry 2057 (class 2604 OID 32854)
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario ALTER COLUMN id SET DEFAULT nextval('usuario_id_seq'::regclass);


--
-- TOC entry 2059 (class 2604 OID 32887)
-- Name: veiculo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY veiculo ALTER COLUMN id SET DEFAULT nextval('veiculo_id_seq'::regclass);


--
-- TOC entry 2182 (class 0 OID 16394)
-- Dependencies: 185
-- Data for Name: avalicacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY avalicacao (estrelas, id_usuario, id) FROM stdin;
\.


--
-- TOC entry 2197 (class 0 OID 32903)
-- Dependencies: 200
-- Data for Name: carona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY carona (id, grupo_id, veiculo_id, data, horariosaida, num_vagas, logorigem_id, logdestino_id) FROM stdin;
1	2	1	3	3	2	2	2
2	13	4	\N	\N	4	4	4
3	13	313	\N	\N	3	1	1
4	13	313	\N	\N	3	1	1
5	13	313	\N	\N	3	1	1
6	13	4	\N	6	6	6	6
7	13	5	10/07/2017	12:00	4	2	3
8	4	3	13/02/2017	13:00	4	3	2
\.


--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 199
-- Name: carona_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('carona_id_seq', 8, true);


--
-- TOC entry 2193 (class 0 OID 32872)
-- Dependencies: 196
-- Data for Name: grupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY grupo (id, nome, descricao, regra, limite) FROM stdin;
3	asdasd	asdas	asdasda	6
4	adasd	adasdad	assad	1
5	adasd	adasdad	assad	1
6	adasd	adasdad	assad	1
7	adasd	adasdad	assad	1
8	dasdsa	asddas	asdad	2
9	das	asdd	asdad	62
10	das	asdd	asdad	62
11	Club da camila	Club novo	Não tem regra	3
12	nosso grupo	grupo	nenhuma	7
13	GRUPO TENSO	GRUPO MUITO TENSO	SE CAIR MORREU	666
1	grupoFacul	so carona	nao zuar	4
\.


--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 195
-- Name: grupo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('grupo_id_seq', 13, true);


--
-- TOC entry 2183 (class 0 OID 32798)
-- Dependencies: 186
-- Data for Name: lagradouro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY lagradouro (id, cep, estado, cidade, distrito, endereco, numero) FROM stdin;
\.


--
-- TOC entry 2188 (class 0 OID 32832)
-- Dependencies: 191
-- Data for Name: nova; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY nova (id, nome) FROM stdin;
1	oi
2	o1313i
\.


--
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 190
-- Name: nova_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('nova_id_seq', 2, true);


--
-- TOC entry 2184 (class 0 OID 32814)
-- Dependencies: 187
-- Data for Name: parada; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY parada (usuario_id, carona_id, lagradouro_id) FROM stdin;
\.


--
-- TOC entry 2186 (class 0 OID 32819)
-- Dependencies: 189
-- Data for Name: test; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY test (a, b) FROM stdin;
\.


--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 188
-- Name: test_a_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('test_a_seq', 1, false);


--
-- TOC entry 2190 (class 0 OID 32851)
-- Dependencies: 193
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (id, nome, email, telefone) FROM stdin;
52	test	test	test
23	bruno	Brunofs_tec@live.com	21981162458
50	Camila Thompson	Camila@gmail.com	21
\.


--
-- TOC entry 2191 (class 0 OID 32858)
-- Dependencies: 194
-- Data for Name: usuario_grupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario_grupo (usuario_id, grupo_id, situacao) FROM stdin;
1	2	\N
\N	1	\N
1	\N	\N
20	6	\N
20	7	\N
20	8	ATIVO
22	9	ATIVO
22	10	ATIVO
23	1	ATIVO
23	3	ATIVO
23	4	ATIVO
50	11	ATIVO
3	4	ATIVO
23	11	INATIVO
23	11	INATIVO
51	12	ATIVO
23	12	ATIVO
23	13	ATIVO
52	13	ATIVO
\.


--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 192
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_seq', 52, true);


--
-- TOC entry 2195 (class 0 OID 32884)
-- Dependencies: 198
-- Data for Name: veiculo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY veiculo (id, modelo, placa, cor, usuario_id) FROM stdin;
3	zeradao	novo	dasda	23
4	adda	ads	ada	23
5	asdadsa	adasdsa	adad	23
6	asdadsa	adasdsa	adad	23
7	xsadd	asdasd	asdsad	23
10	carro zero	dadwqe	preto	1
11	carro zero	dadwqe	marron	1
12	meu carrinho	ZAC-3142	Vermelho	8
13	meu carrinho	ZAC-3142	vermelho	8
8	meu carrinho	ZAC-3142	Vermelho	50
9	Meu novo bebe	Bebe	vermelho	50
14	ford	cd452	verde	51
15	CORSA	DSA-3265	preto	23
1	carro zero	dadwqe	Vermelho	23
2	zeradao	novo	Preto	23
\.


--
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 197
-- Name: veiculo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('veiculo_id_seq', 15, true);


--
-- TOC entry 2062 (class 2606 OID 32805)
-- Name: lagradouro lagradouro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY lagradouro
    ADD CONSTRAINT lagradouro_pkey PRIMARY KEY (id);


--
-- TOC entry 2064 (class 2606 OID 32827)
-- Name: test test_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY test
    ADD CONSTRAINT test_pkey PRIMARY KEY (a);


-- Completed on 2017-02-14 19:16:44

--
-- PostgreSQL database dump complete
--

